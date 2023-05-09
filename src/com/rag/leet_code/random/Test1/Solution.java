package com.rag.leet_code.random.Test1;

import java.util.*;

public class Solution {
    public int minScore(int n, int[][] roads){
        List<List<Pair>> adjecency = new ArrayList<>();
        for (int i = 0; i <n ; i++) {
           adjecency.add(new ArrayList<>());

        }
        for (int i = 0; i < roads.length ; i++) {
           adjecency.get(roads[i][0]).add(new Pair(roads[i][1],roads[i][2]));
           adjecency.get(roads[i][1]).add(new Pair(roads[i][0],roads[i][2]));
        }
        Queue<Pair> queue = new LinkedList<>();
        boolean vis[] = new boolean[n+1];

        //so here 1 and largest int value will be added as a node and length pair
        queue.add(new Pair(1,Integer.MAX_VALUE));
        //ans is largest max value
        int ans = Integer.MAX_VALUE;
        while (!queue.isEmpty()){
            //first time the queue is not empty
            //since it has a Pair 1 and MaxInt value

            //here we are pulling out that Pair
            Pair p = queue.poll();

            //and setting the visited array's index true
            //which the node has in this case 1
            //so the array would go like
            //[false,true,false,false,false]
            vis[p.node] = true;

            //now we compaing the which is the lowest value of that
            //pair in here
            //pair p's value is max int value and ans is also max int value
            ans = Math.min(ans,p.dist);

            //now lets loop over the linked lists of adjacents
            //if is 0 the p.node then we are going to loop through
            //what 0 is connected to
            //if it is connected to 2 and 4 we will get those Pairs
            //so pair two will look like this 2,9
            //pair 4 will look like this 4,7
            for (Pair adjComp : adjecency.get(p.node)
                 ) {
                //now lets see if they are already visited or not
                if(!vis[adjComp.node]){
                    //if it is not visited then let add it to the queue
                    //so queue won't be emptied
                    queue.add(adjComp);
                }

            }

        }
        return 0;
    }
}

class Pair {
    int node;
    int dist;
    Pair(int node,int dist){
        this.node = node;
        this.dist = dist;
    }
}
