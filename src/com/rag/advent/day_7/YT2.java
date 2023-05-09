package com.rag.advent.day_7;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class YT2 {
    Folder currentFolder;

    public static void main(String[] args) {
        YT2 t = new YT2();
        t.doStuff(Util.inputFile());
    }

    public void doStuff(List<String> lines) {
        Folder root = new Folder();
        root.name = "/";
        currentFolder = root;

        for (int i = 1; i < lines.size(); i++) {
            String[] parts = lines.get(i).split(" ");


            if (parts[0].equals("$")) {
                if (parts[1].equals("cd") && parts[2].equals("..")) {
                    currentFolder = currentFolder.parent;
                } else if (parts[1].equals("cd")) {

                    Optional<Node> n = currentFolder.contents.stream().filter(node -> node.name.equals(parts[2])).findFirst();

                    if (n.isPresent()) {
                        currentFolder = (Folder) n.get();
                    }

                }
            } else if (parts[0].equals("dir")) {
                Folder folder = new Folder();
                folder.parent = currentFolder;
                folder.name = parts[1];
                currentFolder.contents.add(folder);
            } else {
                File file = new File();
                file.parent = currentFolder;
                file.name = parts[1];
                file.size = Integer.parseInt(parts[0]);
                currentFolder.contents.add(file);

            }

        }
        List<Folder> smallerFolders = new LinkedList<>();
        List<Folder> toCheck = new LinkedList<>(root.getSubFolders());

        while (toCheck.size() > 0) {
            Folder fold = toCheck.remove(0);
            toCheck.addAll(fold.getSubFolders());
            if (fold.getSize() <= 100000)
                smallerFolders.add(fold);
        }

        long sum = 0;
        for (Folder f : smallerFolders)
            sum += f.getSize();

        System.out.println(sum);

    }

    void setCurrentFolder(Folder folder) {

    }

    public static abstract class Node {
        public String name;
        public Folder parent;

        public abstract long getSize();
    }

    public static class File extends Node {
        public int size;

        @Override
        public long getSize() {
            return size;
        }

    }

    public static class Folder extends Node {
        public List<Node> contents = new LinkedList<>();

        public List<Folder> getSubFolders() {
            List<Folder> folders = new LinkedList<>();
            contents.stream().filter(node -> node instanceof Folder).forEach(node -> folders.add((Folder) node));
            return folders;
        }

        @Override
        public long getSize() {
            long size = 0;
            size = contents.stream().mapToLong(value -> value.getSize()).sum();
            return size;

        }
    }
}
