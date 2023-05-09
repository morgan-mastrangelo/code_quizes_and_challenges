package com.rag.advent.day_7;

import java.util.*;
import java.util.function.Supplier;

import static java.util.stream.Collectors.toList;

public class Day07  {

    public static void main(String[] args) {
            Day07 d = new Day07();
            Object oi = d.solveQ1(Util.inputFile());
            Integer i = (Integer) oi;
        System.out.println(i);

    }




    Object solveQ2(List<String> input) {

        // 1. Build tree
        Dir root = buildTree(input);

        // 2. Sum all
        var list = new ArrayList<Integer>();
        sumAllIntoMemo(root, list);

        // 3. calculate space needed
        Collections.sort(list);
        int totalDiskSpace = 70000000; // size from puzzle
        int filledDiskSpace = list.get(list.size() - 1); // it's sorted, so last is the biggest
        int freeDiskSpace = totalDiskSpace - filledDiskSpace;
        int neededDiskSpace = 30000000 - freeDiskSpace; // size from puzzle

        // 4. because the list of folders is sorted smallest to largest, we can just take the first that is larger or equal than needed
        return list.stream().filter(i -> i >= neededDiskSpace).findFirst().orElse(-1);
    }


    Object solveQ1(List<String> input) {

        // 1. Build tree
        Dir root = buildTree(input);
        System.out.println(root);
        // 2. Sum all
        var list = new ArrayList<Integer>();
        sumAllIntoMemo(root, list);

        // 3. Filter all below 100000 and sum
        return list.stream().filter(i -> i < 100000).mapToInt(i -> i).sum();
    }

    Dir buildTree(List<String> input) {

        var current = new Dir("/", null, new ArrayList<>(), new HashMap<>());
        var root = current;

        for (var line : input) {
            var spl = line.split(" ");

            // ls does not really do anything, so we can skip it
            if (line.equals("$ ls")) continue;

            if (line.equals("$ cd /")) { // cd /  goes to root
                current = root;
            } else if (line.equals("$ cd ..")) { // cd .. goes to parent
                current = current.parent;
            } else if (line.startsWith("$ cd ")) { // if there is still a cd, we need to go to a child
                current = current.children.get(spl[2]);
            } else if (line.startsWith("dir")) { // if there is a dir, we need to add a child to the current dir
                current.children.put(spl[1], Dir.of(spl[1], current));
            } else { // only option left is : a file. we only need it's size
                current.files.add(Integer.parseInt(spl[0]));
            }

        }
        return root;
    }

    static Supplier<List<String>> testData1 = () -> """
            $ cd /
            $ ls
            dir a
            14848514 b.txt
            8504156 c.dat
            dir d
            $ cd a
            $ ls
            dir e
            29116 f
            2557 g
            62596 h.lst
            $ cd e
            $ ls
            584 i
            $ cd ..
            $ cd ..
            $ cd d
            $ ls
            4060174 j
            8033020 d.log
            5626152 d.ext
            7214296 k
            """.lines().collect(toList());


    int sumAllIntoMemo(Dir dir, List<Integer> countMemo) {
        // sum up all files
        int size = dir.files.stream().mapToInt(f -> f).sum();
        // add all child Dir filetotals
        for (Map.Entry<String,Dir> child : dir.children.entrySet()) {
            size += sumAllIntoMemo(child.getValue(), countMemo);
        }
        // add to the memo
        countMemo.add(size);
        //return the size so that the parent can add it to it's total
        return size;
    }

    record Dir(String name, Dir parent, List<Integer> files, Map<String, Dir> children) {
        static Dir of(String name, Dir parent) {
            return new Dir(name, parent, new ArrayList<>(), new HashMap<>());
        }

        @Override
        public String toString() {
            return name;
        }
    }
}