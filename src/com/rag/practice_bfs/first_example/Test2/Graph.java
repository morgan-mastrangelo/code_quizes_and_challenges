package com.rag.practice_bfs.first_example.Test2;


import java.io.*;
import java.util.*;

// This class represents a directed graph using adjacency
// list representation
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
        adj = new LinkedList[v+1];
        for (int i = 1; i < v+1; ++i)
            adj[i] = new LinkedList();

        for (int[] road : roads) {
            addEdge(road[0], road[1]);
        }
    }

    // Function to add an edge into the graph
    void addEdge(int v, int w) {
        adj[v].add(w);
    }



    public int getMinimumDistance() {
        Iterator<Integer> iterator = connectedNodes.iterator();
        List<Integer> minimumDistance = new LinkedList<>();
        while(iterator.hasNext()){
            int node = iterator.next();

            for (int[] road:this.roads
                 ) {
               if(road[0] == node || road[1] == node){
                  minimumDistance.add(road[2]);
               }
            }
        }

        return Collections.min(minimumDistance);
    }

    // prints BFS traversal from a given source s
    void BFS(int s) {
        // Mark all the vertices as not visited(By default
        // set as false)
        boolean visited[] = new boolean[V+1];

        // Create a queue for BFS
        LinkedList<Integer> queue = new LinkedList<Integer>();

        // Mark the current node as visited and enqueue it
        visited[s] = true;
        queue.add(s);

        while (queue.size() != 0) {
            // Dequeue a vertex from queue and print it
            s = queue.poll();
            connectedNodes.add(s);
            System.out.print(s + " ");

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
class Test{
    public static void main(String args[]) {
        String inputString = "[[6,2,7],[3,7,2],[9,6,5],[2,4,9],[7,8,7],[8,4,5],[6,1,10]]";
        int[][] input = Util.convertStrToArray(inputString);
        Graph g = new Graph(9, input);
        g.BFS(1);
        System.out.println("-----------");
        System.out.println(g.getMinimumDistance());
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