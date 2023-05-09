package com.rag.leet_code.minimum_score_path_two_cities.attempt_5;



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
        while (!queue.isEmpty()) {
            int node = queue.poll();
            connectedNodes.add(node);


            for (int i = 0; i < adj[node].size(); i++) {
                int neighborNode = adj[node].get(i);
                if (!visted[neighborNode]) {
                    visted[neighborNode] = true;
                    queue.add(neighborNode);
                }
            }
        }

        Iterator<Integer> iterator = connectedNodes.iterator();
        int minimumDistance = Integer.MAX_VALUE;
        while (iterator.hasNext()) {
            int node = iterator.next();

            for (int[] road : roads) {
                if (road[0] == node || road[1] == node) {
                    minimumDistance = Integer.min(road[2], minimumDistance);
                }
            }
        }

        return minimumDistance;
    }
    public int getDistance(int[][] roads,int node){
        int distance= 0;

        for (int[] road: roads
             ) {
           if(node == road[0] || node == road[1])
               distance = road[2];
           break;
        }
        return distance;
    }

    public static void main(String[] args) {
        String inputString = "[[1,2,9],[2,3,6],[2,4,5],[1,4,7]]";
        int n = 4;
        int[][] input = Util.convertStrToArray(inputString);
        Solution so = new Solution();
       int x = so.minScore(n,input);

        System.out.println(x);
    }
    class Graph {
        private int V; // No. of vertices
        private LinkedList<Integer> adj[]; // Adjacency Lists
        Set<Integer> connectedNodes;
        int[][] roads;

        // Constructor
        Graph(int v, int[][] roads) {

            this.roads = roads;
            connectedNodes = new HashSet<>();
            V = v;
            adj = new LinkedList[v];
            for (int i = 0; i < v; ++i)
                adj[i] = new LinkedList();

            for (int[] road : roads) {
                adj[road[0]].add(road[1]);
                adj[road[1]].add(road[0]);
            }


        }

        // Function to add an edge into the graph


        public int getMinimumDistance() {
            Iterator<Integer> iterator = connectedNodes.iterator();
            int minimumDistance = Integer.MAX_VALUE;
            while (iterator.hasNext()) {
                int node = iterator.next();

                for (int[] road : this.roads) {
                    if (road[0] == node || road[1] == node) {
                        minimumDistance = Integer.min(road[2], minimumDistance);
                    }
                }
            }
            return minimumDistance;
        }

        // prints BFS traversal from a given source s
        void BFS(int s) {
            // Mark all the vertices as not visited(By default
            // set as false)
            boolean visited[] = new boolean[V];

            // Create a queue for BFS
            LinkedList<Integer> queue = new LinkedList<Integer>();

            // Mark the current node as visited and enqueue it
            visited[s] = true;
            queue.add(s);

            while (queue.size() != 0) {
                // Dequeue a vertex from queue and print it
                s = queue.poll();
                connectedNodes.add(s);
                // System.out.print(s + " ");

                // Get all adjacent vertices of the dequeued
                // vertex s If a adjacent has not been visited,
                // then mark it visited and enqueue it
                Iterator<Integer> i = adj[s].listIterator();
                while (i.hasNext()) {
                    int n = i.next();
                    if (!visited[n]) {
                        visited[n] = true;
                        queue.add(n);
                    }
                }
            }
        }

        // Driver method to

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
