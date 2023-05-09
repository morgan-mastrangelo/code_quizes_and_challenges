package com.rag.leet_code.random;

import java.util.*;

public class C {

    List<List<Map<Integer,Integer>>> gr = new ArrayList<>();
    Map<Integer,Integer> map = new HashMap<>();
    List<Map<Integer,Integer>> list = new LinkedList<>();
    List<List<Map<Integer,Integer>>> overallList = new ArrayList<>();


    public void doThis(){
        list.add(map);
        overallList.add(list);
        gr.add(list);
    }

}

class Pair2 extends HashMap {
   HashMap<Integer,Integer> hashMap = new HashMap<>();

}
class Pair{
    int node;
    int dist;
    Pair(int node,int dist){
        this.node=node;
        this.dist=dist;
    }
}

class Solution {
    public int minScore(int n, int[][] roads) {
        List<List<Pair>> adj=new ArrayList<>();
        for(int i=0;i<n+1;i++)
            adj.add(new ArrayList<>());
        for(int i=0;i<roads.length;i++){
            adj.get(roads[i][0]).add(new Pair(roads[i][1],roads[i][2]));
            adj.get(roads[i][1]).add(new Pair(roads[i][0],roads[i][2]));
        }
        Queue<Pair> qu=new LinkedList<>();
        boolean vis[]=new boolean[n+1];
        qu.add(new Pair(1,Integer.MAX_VALUE));
        int ans=Integer.MAX_VALUE;
        while(!qu.isEmpty()){
            Pair p=qu.poll();
            vis[p.node]=true;
            ans=Math.min(ans,p.dist);
            for(Pair adjcomp:adj.get(p.node)){
                if(!vis[adjcomp.node]){
                    qu.add(adjcomp);
                }
            }
        }
        return ans;
    }
}
class Greeting{
    public String sayHello(){
        return "Hello";
    }
    public void printHello(){
        System.out.println("printing Hello message");
    }
    public String sayAndPrintHello(){
        System.out.println("Hello from the method say and print hello method ");
        return "Hello";
    }
}

class Test4{
    public static void main(String[] args) {
        Greeting greeting = new Greeting();

        String helloMessage = greeting.sayHello();
        String helloMessage2 = greeting.sayAndPrintHello();
        System.out.println(helloMessage);
        System.out.println(helloMessage2);
        greeting.printHello();
    }
}