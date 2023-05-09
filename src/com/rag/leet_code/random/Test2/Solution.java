package com.rag.leet_code.random.Test2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {
    int nodeCount;
    List<List<Pair>> nodes;
    int[][] roads;
    int minDistance;
    public int minScore(int nodeCount, int[][] roads) {
        this.roads = roads;
        this.nodeCount = nodeCount;
        nodes = new ArrayList<>();
        for (int i = 0; i < nodeCount + 1; i++) {
            nodes.add(new ArrayList<>());
        }

        for (int[] road : roads) {
            nodes.get(road[0]).add(new Pair(road[1], road[2]));
            nodes.get(road[1]).add(new Pair(road[0], road[2]));
        }

        for (int i = 1; i < nodeCount + 1; i++) {
            System.out.println("node " + i + " has ");
            for (int j = 0; j < nodes.get(i).size(); j++) {
                System.out.println(nodes.get(i).get(j));
            }
        }
        Queue<Pair> nodeQueue = new LinkedList<>();
        boolean[] visitedNodeStatus = new boolean[nodeCount + 1];

        nodeQueue.add(new Pair(1, Integer.MAX_VALUE));

        minDistance = Integer.MAX_VALUE;
        while (!nodeQueue.isEmpty()) {
            //popping out the top Pair inside the nodeQueue
            Pair poppedOutPair = nodeQueue.poll();
            //setting it true
            visitedNodeStatus[poppedOutPair.node] = true;
            minDistance = Integer.min(poppedOutPair.distance, minDistance);
            List<Pair> pairList = nodes.get(poppedOutPair.node);
            for (int i = 0; i < pairList.size(); i++) {
                if (!visitedNodeStatus[pairList.get(i).node]) {
                    nodeQueue.add(pairList.get(i));
                }
            }
        }
        return minDistance;
    }


}

class Pair {
    Integer node;
    Integer distance;

    public Pair(Integer node, Integer distance) {
        this.node = node;
        this.distance = distance;
    }

    @Override
    public String toString() {
        return "node : " + node + " distance " + distance;
    }
}

class Util {
    public static int[][] convertStrToArray(String input) {
        input = input.replace("[", "{");
        input = input.replace("]", "}");
        input = input.substring(1, input.length());
        input = input.substring(1, input.length());
        input = input.substring(0, input.length() - 1);
        input = input.substring(0, input.length() - 1);

        int arrayLength = 0;
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == ',' && input.charAt(i - 1) == '}') {
                arrayLength++;
            }
        }
        arrayLength++;
        int[][] intArray = new int[arrayLength][3];


        input = input.replace("[", "");
        input = input.replace("]", "");
        input = input.replace(",", "");
        input = input.replace("}", "");
        input = input.replace("{", "");

        int row = 0;
        for (int i = 0; i < intArray.length; i++) {
            for (int j = 0; j < intArray[0].length; j++) {

                intArray[i][j] = Character.getNumericValue(input.charAt(row));
                row++;
            }
        }


        return intArray;
    }
}

class Test {

    public static void main(String[] args) {
        int nodeCount = 2;
        String inputString = "[[1,2,9],[2,3,6],[2,4,5],[1,4,7]]";
        int[][] input = Util.convertStrToArray(inputString);
        Solution solution = new Solution();
        solution.minScore(nodeCount, input);
        System.out.println(solution.minDistance);

    }
}
