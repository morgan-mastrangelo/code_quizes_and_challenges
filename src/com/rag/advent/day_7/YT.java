package com.rag.advent.day_7;

import java.util.LinkedList;
import java.util.List;

public class YT {


    public static void main(String[] args) {
        YT t = new YT();
        t.solve(Util.inputFile());
    }

    void solve(List<String> lines) {
        Folder root = new Folder();
        root.name = "/";
        Folder currentFolder = root;
        for (int i = 1; i < lines.size(); i++) {
            String line = lines.get(i);
            String[] parts = lines.get(i).split(" ");
            if (parts[0].equals("dir")) {
                Folder folder = new Folder();
                folder.parent = currentFolder;
                folder.name = parts[1];
                currentFolder.content.add(folder);
            } else if (parts[0].equals("$")) {
                if (line.startsWith("$ cd ..")) {
                    currentFolder = currentFolder.parent;
                } else if (line.startsWith("$ cd ")) {
                    System.out.println(line);
                    for (Node node : currentFolder.content) {
                        if (node.name.equals(parts[2])) {
                            currentFolder = (Folder) node;
                        }
                    }
                }
            } else {
                File file = new File();
                file.parent = currentFolder;
                file.size = Integer.parseInt(parts[0]);
                currentFolder.content.add(file);

            }

        }

        List<Folder> f = new LinkedList<>();
        List<Folder> toCheck = new LinkedList<>();
        toCheck.addAll(root.getSubFolders());

        while (toCheck.size()>0){
            Folder fold = toCheck.remove(0);
            toCheck.addAll(fold.getSubFolders());
            if(fold.size() <= 100000){
                f.add(fold);
            }

        }
        long sum = f.stream().mapToLong(value -> value.size()).sum();
    }

    static abstract class Node {
        String name;
        public Folder parent;

        public abstract long size();
    }

    static class File extends Node {
        int size;

        public long size() {
            return 0;
        }
    }

    static class Folder extends Node {
        public List<Node> content = new LinkedList<>();

        public List<Folder> getSubFolders() {
            List<Folder> subFolder = new LinkedList<>();
            content.stream().filter(node -> node instanceof Folder).forEach(node -> subFolder.add((Folder) node));
            return subFolder;
        }

        public long size() {
            return content.stream().mapToLong(value -> value.size()).sum();

        }
    }

}
