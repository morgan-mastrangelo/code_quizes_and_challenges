package com.rag.leet_code.minimum_score_path_two_cities.attempt_1;

import java.util.Iterator;
import java.util.LinkedList;

public class Solution {
    public int minScore(int n, int[][] roads) {


        int roadsLength = roads.length;
        //this process is to add nodes and the connected nodes/add edges
        for (int i = 0; i < roadsLength; i++) {
            int connectingNode = 0;
            for (int j = 0; j < roads[0].length; j++) {
                if (j == 0) {
                    connectingNode = roads[i][j];
                }
                if (j == 1) {
                    int joiningNode = roads[i][j];
                    System.out.println("Connecting node is " + connectingNode + " joining node is " + joiningNode);
                    graph.addEdges(connectingNode, joiningNode);
                }
            }
        }
        return 0;
    }

    Graph graph;

    public Solution(int nodeCount) {
        graph = new Graph(nodeCount);
    }

    //this class is to the DFS traverse
    class Graph {
        int nodeCount;
        LinkedList<Integer>[] vertices;

        Graph(int nodeCount) {
            this.nodeCount = nodeCount;
            vertices = new LinkedList[nodeCount];
            for (int i = 0; i < nodeCount; i++) {
                vertices[i] = new LinkedList<>();
            }
        }

        void addEdges(int node, int joiningNode) {
            vertices[node].add(joiningNode);

        }

        void DFSMechanism(int node, boolean[] visited) {
            visited[node] = true;
            Iterator<Integer> i = vertices[node].listIterator();
            while (i.hasNext()) {
                int n = i.next();
                if (!visited[n]) {
                    DFSMechanism(n, visited);
                }
            }
        }

        void doDFS(int startingNode) {
            boolean[] visited = new boolean[nodeCount];
            DFSMechanism(1, visited);
        }
    }

    public static void main(String[] args) {
        int n = 4;
        Solution s = new Solution(n);
        String input = "[[1,2,9],[2,3,6],[2,4,5],[1,4,7]]";

        s.minScore(n, Solution.convertStrToArray(input));
        System.out.println("ok");

    }

    //this method is to convert the input to 2d array from leetcode site
    //it is much comfortable to work in my pc
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
