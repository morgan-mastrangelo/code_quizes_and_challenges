package com.rag.advent.day_8;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class PartTwo {
    public static void main(String[] args) {
        PartTwo t = new PartTwo();
//        t.doStuff(Util.inputFileTest());
        t.doStuff(Util.inputFile());
//        t.calculateBlockingTreeCount();
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
        int outLineTreeCount = (2 * row) + ((column - 2) * 2);

        List<List<Integer>> horiList = new LinkedList<>();
        List<List<Integer>> vertiList = new LinkedList<>();
        createVerticalList(vertiList, column);

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
        int totalScenicScore = 0;
        List<Integer> scenicScoreList = new LinkedList<>();
        for (int i = 1; i < horiList.size() - 1; i++) {

            for (int j = 1; j < horiList.get(i).size() - 1; j++) {
                int tree = horiList.get(i).get(j);
                List<Integer> hList = horiList.get(i);
                List<Integer> vList = vertiList.get(j);
                int vPos = i;
                int hPos = j;
                System.out.println("+++++++++++++++++++++");
                System.out.println(horiList.get(i).get(j));
                System.out.println("hPos is " + hPos + " vPos is " + vPos);
//                System.out.println(horiList.get(i));
//                System.out.println(vertiList.get(j));
                int scenicScore = calculateBlockingTreeCount(tree,hList,vList,hPos,vPos);
                System.out.println("scenice socre is "+scenicScore);
                scenicScoreList.add(scenicScore);
            }

            System.out.println("=============");
        }
        int highestScenicScore = scenicScoreList.stream().max(Integer::compare).get();
        System.out.println("visible tree count is "+visibleTreeCounts);
        System.out.println("total visible tree count is " + (visibleTreeCounts + outLineTreeCount));
        System.out.println("total scenic score is  "+totalScenicScore);
        System.out.println("Highest scenic score is "+highestScenicScore);

    }


    public boolean isTreeVisible(int tree, List<Integer> hList, List<Integer> vList, int hPos, int vPos) {
        boolean isTreeVisibleFromOutside = true;
        //if list reveresd tree's ideal index position
        int hRPos = hList.size() - hPos - 1;
        int vRPos = vList.size() - vPos - 1;
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
    public int calculateBlockingTreeCount( int tree, List<Integer> hList, List<Integer> vList, int hPos, int vPos) {
        int scenicScore = 0;


        int hRPos = hList.size() - 1 - hPos;
        int vRPos = vList.size() - 1 - vPos;


        int horizontalCount = 0;
        int verticalCount = 0;
        int reverseHorizontalCount = 0;
        int reverseVerticalCount = 0;
        horizontalCount = tallerTreeCounter(tree, hPos, hList, horizontalCount);
        System.out.println("horizontalCount is " + horizontalCount);

        verticalCount = tallerTreeCounter(tree,vPos,vList,verticalCount);
        System.out.println("vertical count is "+verticalCount);
        Collections.reverse(hList);
        Collections.reverse(vList);

        reverseHorizontalCount = tallerTreeCounter(tree,hRPos,hList,reverseHorizontalCount);
        System.out.println("reverse horizontal count is " + reverseHorizontalCount);

        reverseVerticalCount = tallerTreeCounter(tree,vRPos,vList,reverseVerticalCount);
        System.out.println("reverse vertical count is " + reverseVerticalCount);
        Collections.reverse(hList);
        Collections.reverse(vList);

        scenicScore = horizontalCount*verticalCount*reverseHorizontalCount*reverseVerticalCount;
        System.out.println("scenic score is "+scenicScore);

        return scenicScore;
    }
    //sample testing
    public void calculateBlockingTreeCount() {
        int scenicScore = 0;
        int[] h = {2, 5, 5, 1, 2};
        int[] v = {3, 5, 3, 5, 3};
        int tree = 5;
        int hPos = 2;
        int vPos = 1;
        int hRPos = h.length - 1 - hPos;
        int vRPos = v.length - 1 - vPos;
        List<Integer> hList = Arrays.stream(h).boxed().collect(Collectors.toList());
        List<Integer> vList = Arrays.stream(v).boxed().collect(Collectors.toList());

        int topTree = 0;
        int horizontalCount = 0;
        int verticalCount = 0;
        int reverseHorizontalCount = 0;
        int reverseVerticalCount = 0;
        int startingPoint;
        horizontalCount = tallerTreeCounter(tree, hPos, hList, horizontalCount);
        System.out.println("horizontalCount is " + horizontalCount);

        verticalCount = tallerTreeCounter(tree,vPos,vList,verticalCount);
        System.out.println("vertical count is "+verticalCount);
        Collections.reverse(hList);
        Collections.reverse(vList);

        reverseHorizontalCount = tallerTreeCounter(tree,hRPos,hList,reverseHorizontalCount);
        System.out.println("reverse horizontal count is " + reverseHorizontalCount);

        reverseVerticalCount = tallerTreeCounter(tree,vRPos,vList,reverseVerticalCount);
        System.out.println("reverse vertical count is " + reverseVerticalCount);
        Collections.reverse(hList);
        Collections.reverse(vList);

        scenicScore = horizontalCount*verticalCount*reverseHorizontalCount*reverseVerticalCount;
        System.out.println(scenicScore);
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

    public int tallerTreeCounter(int tree, int hPos, List<Integer> hList, int count) {
        for (int i = hPos - 1; i >= 0; i--) {

            int traversingTree = hList.get(i);
            if (traversingTree >= tree) {
                System.out.println(traversingTree);
                count++;
                break;
            } else if (traversingTree < tree) {
                System.out.println(traversingTree);
                count++;
            }
        }
        return count;
    }

    void createVerticalList(List<List<Integer>> list, int size) {
        for (int u = 0; u < size; u++) {
            list.add(new LinkedList<Integer>());
        }
    }
}
