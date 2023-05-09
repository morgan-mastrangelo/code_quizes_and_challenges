package com.rag.practice_bfs.first_example;

import java.util.*;

public class Node<T> {
    private T value;
    private Set<Node<T>> neighbors;
    public Node(T value){
        this.value = value;
        neighbors = new HashSet<>();
    }

    public void connect(Node<T> node){
        if(this==node){
            throw new IllegalArgumentException("Can't connect node to itself");
        }
        this.neighbors.add(node);
        node.neighbors.add(this);
    }

    public static <T>Optional<Node<T>> search(T value, Node<T> start){
        Queue<Node<T>> queue = new ArrayDeque<>();
        queue.add(start);


        Node<T> currentNode;
        while(!queue.isEmpty()){
           currentNode = queue.remove();


        }
        return null;
    }
}
