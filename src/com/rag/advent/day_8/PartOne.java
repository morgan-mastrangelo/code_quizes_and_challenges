package com.rag.advent.day_8;

import java.util.*;

public class PartOne {
    public static void main(String[] args) {
        PartOne t = new PartOne();
//        t.doStuff(Util.inputFileTest());
        t.doStuff(Util.inputFile());
    }

    void doStuff(List<String> input) {
        String horizontalLine = "";
        int column = 0;
        int row = 0;
        for (String tree : input) {
            horizontalLine = tree;
            System.out.println(tree);
            row++;
        }
        column = horizontalLine.length();
        System.out.println("col and rows are " + column + " " + row);
        int outLineTreeCount = (2 * row) + ((column - 2) * 2);

        List<List<Integer>> horiList = new LinkedList<>();
        List<List<Integer>> vertiList = new LinkedList<>();
        createList(vertiList, column);

        //add all the vertical lines

        for (String tree : input) {
            for (int i = 0; i < tree.length(); i++) {
                vertiList.get(i).add(Integer.parseInt(Character.toString(tree.charAt(i))));
            }
        }
        //add all the horizontal lines
        for (String tree : input) {
            List<Integer> mylist = new LinkedList<>();
            for (int i = 0; i < tree.length(); i++) {
                mylist.add(Integer.parseInt(Character.toString(tree.charAt(i))));
            }
            horiList.add(mylist);
        }
        int visibleTreeCounts = 0;
        for (int i = 1; i < horiList.size() - 1; i++) {

            for (int j = 1; j < horiList.get(i).size() - 1; j++) {
                int tree = horiList.get(i).get(j);
                List<Integer> hList = horiList.get(i);
                List<Integer> vList = vertiList.get(j);
                int vPos = i;
                int hPos = j;
                System.out.println(horiList.get(i).get(j) + " hPos is " + hPos + " vPos is " + vPos);
                System.out.println(horiList.get(i));
                System.out.println(vertiList.get(j));
                if (isTreeVisible(tree, hList, vList, hPos, vPos)) {
                    visibleTreeCounts++;
                }
                System.out.println("000000000000000============");
            }

            System.out.println("=============");
        }
        System.out.println(visibleTreeCounts);
        System.out.println("total visible tree count is " + (visibleTreeCounts + outLineTreeCount));

    }


    public boolean isTreeVisible(int tree, List<Integer> hList, List<Integer> vList, int hPos, int vPos) {
        boolean isTreeVisibleFromOutside = true;

//        int tree = 3;
//        //positions
//        int hPos = 2;
//        int vPos = 2;
        //positions in reverse
        int hRPos = hList.size() - hPos - 1;
        int vRPos = vList.size() - vPos - 1;
//        List<Integer> hList = Arrays.stream(iH).boxed().collect(Collectors.toList());
//        List<Integer> vList = Arrays.stream(iV).boxed().collect(Collectors.toList());
        boolean isTallerTreeFoundStartHori = false;
        boolean isTallerTreeFoundStartVerti = false;
        boolean isTallerTreeFoundReverseHori = false;
        boolean isTallerTreeFoundReverseVerti = false;

        isTallerTreeFoundStartHori = compareFromEveryWhere(tree, hPos, hList, isTallerTreeFoundStartHori);
        isTallerTreeFoundStartVerti = compareFromEveryWhere(tree, vPos, vList, isTallerTreeFoundStartVerti);
        Collections.reverse(hList);
        Collections.reverse(vList);

        isTallerTreeFoundReverseHori = compareFromEveryWhere(tree, hRPos, hList, isTallerTreeFoundReverseHori);
        isTallerTreeFoundReverseVerti = compareFromEveryWhere(tree, vRPos, vList, isTallerTreeFoundReverseVerti);


        System.out.println(isTallerTreeFoundStartHori);
        System.out.println(isTallerTreeFoundStartVerti);
        System.out.println(isTallerTreeFoundReverseHori);
        System.out.println(isTallerTreeFoundReverseVerti);
        if (isTallerTreeFoundStartHori && isTallerTreeFoundStartVerti && isTallerTreeFoundReverseHori && isTallerTreeFoundReverseVerti) {
            isTreeVisibleFromOutside = false;
        }
        Collections.reverse(hList);
        Collections.reverse(vList);
        return isTreeVisibleFromOutside;
    }

    public boolean compareFromEveryWhere(int tree, int pos, List<Integer> trees, boolean isTallerTreeFound) {
        for (int i = 0; i < pos; i++) {
            if (trees.get(i) >= tree) {
                System.out.println(trees.get(i));
                isTallerTreeFound = true;
            } else {
                System.out.println("tree size is " + trees.get(i) + " tree is " + tree);
            }

        }


        return isTallerTreeFound;
    }

    void createList(List<List<Integer>> list, int size) {
        for (int u = 0; u < size; u++) {
            list.add(new LinkedList<Integer>());
        }
    }
}
