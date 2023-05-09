package com.rag.practice_bfs.first_example.shortest_path;


import java.util.*;

public class BFS {

    private int V; // number of vertices
    private LinkedList<Integer> adj[]; // adjacency list representation

    public BFS(int v) {
        V = v;
        adj = new LinkedList[v];
        for (int i=0; i<v; i++) {
            adj[i] = new LinkedList();
        }
    }

    // add an edge to the graph
    public void addEdge(int v, int w) {
        adj[v].add(w);
        adj[w].add(v);
    }

    // find the shortest path between two nodes using BFS
    public int shortestPath(int start, int end) {
        boolean visited[] = new boolean[V]; // array to keep track of visited vertices
        int distance[] = new int[V]; // array to store distance from start node

        Queue<Integer> queue = new LinkedList<Integer>();
        visited[start] = true;
        queue.add(start);

        while (queue.size() != 0) {
            int vertex = queue.poll();

            Iterator<Integer> i = adj[vertex].listIterator();
            while (i.hasNext()) {
                int n = i.next();
                if (!visited[n]) {
                    visited[n] = true;
                    distance[n] = distance[vertex] + 1;
                    queue.add(n);
                }
            }
        }

        return distance[end];
    }

    public static void main(String args[]) {
        BFS g = new BFS(8);


        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 3);
        g.addEdge(1, 4);
        g.addEdge(2, 5);
        g.addEdge(2, 6);
        g.addEdge(3, 7);
        g.addEdge(4, 7);
        g.addEdge(5, 7);
        g.addEdge(6, 7);

        System.out.println(" " + g.shortestPath(0, 7));
    }
}
