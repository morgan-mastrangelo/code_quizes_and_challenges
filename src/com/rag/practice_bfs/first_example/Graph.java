package com.rag.practice_bfs.first_example;

import java.util.Iterator;
import java.util.LinkedList;

public class Graph {
    private int nodeCount;
    private LinkedList<Integer>[] adj;

    Graph(int nodeCount) {
        this.nodeCount = nodeCount;
        adj = new LinkedList[nodeCount];
        for (int i = 0; i < nodeCount; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    void addEdge(int node, int connectingNode) {
        adj[node].add(connectingNode);
    }

    void BFS(int startingNode) {
        boolean visited[] = new boolean[nodeCount];

        LinkedList<Integer> queue = new LinkedList<>();
        visited[startingNode] = true;

        //adding the stared node which 0 to the queue
        queue.add(startingNode);


        while (queue.size() != 0) {
            startingNode = queue.poll();
            System.out.print(startingNode + "  ");
            //it will print out 0
            Iterator<Integer> i = adj[startingNode].listIterator();
            //here we get the sub nodes that the zero holds,
            //zero holds 1,2
            //lets iterate through the loop

            while (i.hasNext()) {

                // int n could be 1 or 2
                int n = i.next();
                //lets check if 1 is visited or not
                //if its not visited we go inside the if statement
                // traverse and add the node to the queue
                //so queue won't be empty
//                System.out.println("node "+startingNode +" has "+n);
                if (!visited[n]) {
                    //since we are visiting the node make sure to
                    //mark it down on the boolean array
                    visited[n] = true;
                    queue.add(n);
                }


            }

        }
    }

    public static void main(String[] args) {
        Graph g = new Graph(4);
        g.addEdge(0,1);
        g.addEdge(0,2);
        g.addEdge(1,2);
        g.addEdge(2,0);
        g.addEdge(2,3);
        g.addEdge(3,3);
        System.out.println("bro fist");
        g.BFS(2);

    }
}
