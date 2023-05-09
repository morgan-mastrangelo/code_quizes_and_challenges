package com.rag.leet_code.minimum_score_path_two_cities.back_up;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;

public class Solution {
    public int minScore(int nodeCount, int[][] roads) {
        Graph graph = new Graph(nodeCount+1,roads);
        graph.BFS(1);
        // System.out.println(graph.getMinimumDistance());
        return graph.getMinimumDistance();
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
                addEdge(road[0], road[1]);
            }
        }

        // Function to add an edge into the graph
        void addEdge(int v, int w) {
            adj[v].add(w);
            adj[w].add(v);
        }

        public void createGraph(int[][] roads) {
            for (int[] road : roads) {
                addEdge(road[0], road[1]);
            }
        }

        public int getMinimumDistance() {
            Iterator<Integer> iterator = connectedNodes.iterator();
            int minimumDistance = Integer.MAX_VALUE;
            while(iterator.hasNext()){
                int node = iterator.next();

                for (int[] road:this.roads
                ) {
                    if(road[0] == node || road[1] == node){
                        minimumDistance = Integer.min(road[2],minimumDistance);
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

