package com.rag.leet_code.number_of_islands.attempt_1;

import java.util.*;

public class Solution {
    //    private char[][] grid = new char[5][4];
    public String[][] grid = {{"1", "1", "0", "0", "0"}, {"1", "1", "0", "0", "0"}, {"0", "0", "1", "0", "0"}, {"0", "0", "0", "1", "1"}};
    public char[][] charGrid;

    public Solution() {
        charGrid = stringToCharArray(grid);
    }

    public char[][] stringToCharArray(String[][] ar) {
        char[][] charAr = new char[4][5];
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < ar.length; i++) {
            int count = 0;
            for (String s : ar[i]) {

                sb.append(s);
                charAr[i][count] = s.charAt(0);
                count++;
            }

        }


        return charAr;
    }

    Set<Integer[]> set = new HashSet<>();
    Set<List<Integer>> islands = new HashSet<>();

    public boolean isValidPoint(int x, int y) {
        boolean state = false;
//        System.out.println("x is " + x + " y is " + y);
        if (x >= 0 && y >= 0 && x < grid.length && y < grid[0].length) {
            state = true;
        }
        return state;
    }

    public void doMainProcess(char point, int x, int y) {
//        System.out.println("Point is " + point);
        boolean state = isValidPoint(x, y);

        if (!state) {
            return;
        }
        List<Integer> listInt = new ArrayList<>();
        if (islands.isEmpty()) {
            listInt.add(x);
            listInt.add(y);

        }

        System.out.println("x is " + x + " y is " + y);

    }

    public void traverse(char point, int x, int y) {

        doMainProcess(point, x + 1, y);
        doMainProcess(point, x - 1, y);
        doMainProcess(point, x, y + 1);
        doMainProcess(point, x, y - 1);

    }

    public boolean checkIslands() {
        boolean state = false;

        List<List<Integer>> listArray = new LinkedList() ;
        List<Integer> i1 = new LinkedList<>();
        i1.add(0);
        i1.add(1);

        List<Integer> i2 = new LinkedList<>();
        i2.add(2);
        i2.add(2);

        listArray.add(i1);
        listArray.add(i2);

        List<Integer> i3 = new LinkedList<>();
        i3.add(2);
        i3.add(2);

        System.out.println(listArray.contains(i3));
        return state;
    }

    public int numIslands(char[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int l = 0; l < grid[0].length; l++) {
                char point = grid[i][l];
//                System.out.println(point + " ");
                if (point == '1') {
                    System.out.println("Point is " + point + " original  x " + i + " orignal y is " + l);
                    traverse(grid[i][l], i, l);
                }
            }
            System.out.println("------------");
        }
        return 0;
    }
}


class Test {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.checkIslands());
//        s.numIslands(s.stringToCharArray(s.grid));
//        s.set.stream().forEach(integers -> System.out.println(integers[0] + " " + integers[1]));
    }
}