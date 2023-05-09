package com.rag.leet_code.minimum_score_path_two_cities.attempt_4;


import java.util.*;

public class Solution {
    List<Boolean> visitedSet;

    public int minScore(int nodeCount, int[][] roads) {
        int nc = nodeCount;
        System.out.println(nc);
        Graph graph = new Graph(nc, roads);
        graph.BFS(1);
        System.out.println(graph.getMinimumDistance());
        return graph.getMinimumDistance();
    }

    class Graph {

        private int V; // No. of vertices
        private LinkedList<Integer> adj[]; // Adjacency Lists
        Set<Integer> connectedNodes;
        int[][] roads;
        boolean[] visited;

        // Constructor
        Graph(int v, int[][] roads) {
            visitedSet = new LinkedList<>();
            this.roads = roads;
            connectedNodes = new HashSet<>();
            V = v;
            System.out.println(V);
            adj = new LinkedList[1 + v];
            for (int i = 1; i < v + 1; ++i)
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
            System.out.println("checking minimum");
            Iterator<Integer> iterator = connectedNodes.iterator();
            List<Integer> minimumDistance = new LinkedList<>();
            while (iterator.hasNext()) {
                int node = iterator.next();

                for (int[] road : this.roads) {
                    if (road[0] == node || road[1] == node) {
                        System.out.println(road[2]);
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
            visited = new boolean[V + 1];

            // Create a queue for BFS
            LinkedList<Integer> queue = new LinkedList<Integer>();

            // Mark the current node as visited and enqueue it
            visited[s] = true;
            visitedSet.add(true);
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
            System.out.println("\n");
            for (boolean visit : visited) {
                System.out.println(visit);
            }
            System.out.println("length of boolean array is " + visited.length);
            System.out.println("connected nodes ares ");
            System.out.println(connectedNodes);
        }

        // Driver method to

    }
}

class Test {
    public static void main(String args[]) {
        String inputString = "[[6,2,7],[3,7,2],[9,6,5],[2,4,9],[7,8,7],[8,4,5],[6,1,10]]";
        int n = 9;
        int[][] input = Util.convertStrToArray(inputString);
        Solution g = new Solution();
        System.out.println("-----------");
        System.out.println(g.minScore(9, input));
//        Graph graph = new Graph(n,input);
//        graph.addRoadsEdges();
//        graph.BFS(0);

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

class Graph {
    private int V;                              //number of nodes in the graph
    private LinkedList<Integer> adj[];              //adjacency list
    private Queue<Integer> queue;                   //maintaining a queue

    int[][] roads;

    Graph(int v,int[][] roads) {
        this.roads = roads;
        V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; i++) {
            adj[i] = new LinkedList<>();
        }
        queue = new LinkedList<Integer>();
    }


    void addEdge(int v, int w) {
        adj[v].add(w);                          //adding an edge to the adjacency list (edges are bidirectional in this example)
    }

    void addRoadsEdges() {
        for (int[] road : roads) {
            System.out.println((road[0]-1)+"  "+(road[1]-1));
            addEdge(road[0]-1, road[1]-1);
        }
    }

    void BFS(int n) {

        boolean nodes[] = new boolean[V];       //initialize boolean array for holding the data
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