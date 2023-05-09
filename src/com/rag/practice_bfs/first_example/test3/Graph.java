package com.rag.practice_bfs.first_example.test3;

import java.util.LinkedList;
import java.util.Queue;

public class Graph {
    private int V;                              //number of nodes in the graph
    private LinkedList<Integer> adj[];              //adjacency list
    private Queue<Integer> queue;                   //maintaining a queue

    Graph(int v) {
        V = v;
        adj = new LinkedList[v+1];
        for (int i = 1; i < v+1; i++) {
            adj[i] = new LinkedList<>();
        }
        queue = new LinkedList<Integer>();
    }


    void addEdge(int v, int w) {
        System.out.println(v+" "+w);
        adj[v].add(w);
        adj[w].add(v);
        //adding an edge to the adjacency list (edges are bidirectional in this example)
    }

    void BFS(int n) {

        boolean nodes[] = new boolean[V+1];       //initialize boolean array for holding the data
        int a = 0;

        nodes[n] = true;
        queue.add(n);                   //root node is added to the top of the queue

        while (queue.size() != 0) {
            n = queue.poll();             //remove the top element of the queue
            System.out.print(n + " ");           //print the top element of the queue

            for (int i = 0; i < adj[n].size(); i++)  //iterate through the linked list and push all neighbors into queue
            {
                a = adj[n].get(i);
                if (!nodes[a])                    //only insert nodes into queue if they have not been explored already
                {
                    nodes[a] = true;
                    queue.add(a);
                }
            }
        }
    }
}
class Test{
    public static void main(String[] args) {
        Graph g = new Graph(9);
        g.addEdge(6,2);
        g.addEdge(3,7);
        g.addEdge(9,6);
        g.addEdge(2,4);
        g.addEdge(7,8);
        g.addEdge(8,4);
        g.addEdge(6,1);

        g.BFS(1);
    }
}