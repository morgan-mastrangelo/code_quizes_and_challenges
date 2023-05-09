package com.rag.leet_code.minimum_score_path_two_cities.attempt_6;


import java.util.*;

public class Solution {
    public int minScore(int nodeCount, int[][] roads) {


        // System.out.println(graph.getMinimumDistance());
        int v = nodeCount + 1;
        Set<Integer> connectedNodes = new HashSet<>();
        LinkedList<Integer> adj[] = new LinkedList[v];
        boolean[] visted = new boolean[v];

        for (int i = 0; i < v; i++) {
            adj[i] = new LinkedList<>();
        }
        for (int[] road : roads) {
            adj[road[0]].add(road[1]);
            adj[road[1]].add(road[0]);
        }
        Queue<Integer> queue = new ArrayDeque<>();
        visted[1] = true;
        queue.add(1);
        int min = Integer.MAX_VALUE;
        while (!queue.isEmpty()) {
            int node = queue.poll();
            connectedNodes.add(node);
            System.out.println("node is "+ node);
            min = Integer.min(min, getDistance(roads, node));
            for (int i = 0; i < adj[node].size(); i++) {
                int neighborNode = adj[node].get(i);
                if (!visted[neighborNode]) {
                    visted[neighborNode] = true;
                    queue.add(neighborNode);
                }
            }
        }

        return min;
    }

    public int getDistance(int[][] roads, int node) {

        System.out.println(node);
        int min = Integer.MAX_VALUE;
        for (int[] road : roads
        ) {
            if (node == road[0] || node == road[1]) {

                min = Integer.min(min,road[2]);
                System.out.println("distance is "+min);
            }

        }
        return min;
    }

    public static void main(String[] args) {
        String inputString = "[[1,2,9],[2,3,6],[2,4,5],[1,4,7]]";
        int n = 4;
        int[][] input = Util.convertStrToArray(inputString);
        Solution so = new Solution();
        int x = so.minScore(n, input);

        System.out.println(x);
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
