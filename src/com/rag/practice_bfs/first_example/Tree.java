package com.rag.practice_bfs.first_example;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Tree<T> {
    private T value;
    private List<Tree<T>> children;

    public Tree(T value){
        this.value = value;
        this.children = new ArrayList<>();
    }
    public static <T> Tree<T> of (T value){
        return new Tree<> (value);
    }

    public Tree<T> addChild(T value){
        Tree<T> newChild = new Tree<>(value);
        children.add(newChild);
        return newChild;
    }



}
