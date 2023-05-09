package com.rag.leet_code.minimum_score_path_two_cities.practice_dfs;

import java.util.Iterator;
import java.util.LinkedList;

public class Graph {
    private int V;
    private LinkedList<Integer>[] vertices;

    Graph(int v) {
        V = v;
        vertices = new LinkedList[V];
        for (int i = 0; i < v; i++) {
            vertices[i] = new LinkedList<>();
        }
    }

    //function to add an edge into the graph
    void addEdge(int v, int w) {
        vertices[v].add(w);
    }

    void DFSUtil(int v, boolean visited[]) {
        visited[v] = true;
//        System.out.println((v + " "));
        Iterator<Integer> i = vertices[v].listIterator();
        while (i.hasNext()) {
            int n = i.next();
            System.out.println(v + " is linked upto " + n);
            if (!visited[n])
                DFSUtil(n, visited);
        }
    }

    void DFS(int v) {
        boolean visited[] = new boolean[V];
        DFSUtil(v, visited);
    }

    public static void main(String args[]) {
        Graph g = new Graph(5);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 3);
        g.addEdge(3, 3);
        g.addEdge(3,4);
        g.addEdge(1,4);

        System.out.println("Following is Depth First Traversal " + "(starting from vertex 2)");

        // Function call
        g.DFS(0);
    }

}
