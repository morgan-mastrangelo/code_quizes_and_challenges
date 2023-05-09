package com.rag.leet_code.concatenated_words.attempt_2;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test2 {
    public static void main(String[] args) {
        String[] testCase_1 = {"a", "b", "ab", "abc"};
        String[] testCase_2 = {"cat", "cats", "catsdogcats", "dog", "dogcatsdog", "hippopotamuses", "rat", "ratcatdogcat"};
        Solution solution = new Solution();
        solution.findAllConcatenatedWordsInADict(testCase_1);
    }
}

class Solution {
    LinkedList<String> list;
    LinkedList<String> concList;
    LinkedList<String> setToList;
    Set<String> otherOnes = new HashSet<>();
    Set<String> set = new HashSet<>();

    public List<String> findAllConcatenatedWordsInADict(String[] words) {

        list = new LinkedList<String>(Arrays.asList(words));


        for (String word : words) {
            for (String lookingWord : words) {
                String modifiedWord = lookingWord;
                if (!word.equals(lookingWord)) {

                    if (word.contains(lookingWord)) {

                        set.add(word);

                    }
                }
            }
            System.out.println("------------");
        }


        System.out.println("this is the set");
        System.out.println(set);
        setToList = new LinkedList<>(set.stream().toList());
        System.out.println("set to list is " + setToList);
        System.out.println("===========");
        finalFilter(setToList, list);
        return setToList;
    }


    public void finalFilter(LinkedList<String> list, LinkedList<String> originalList) {
        LinkedList<String> myList = new LinkedList<>(list);

        for (String lookingFor : list
        ) {
            System.out.println("looking for " + lookingFor);
            for (String lookingAt : originalList
            ) {
                if (!lookingFor.equals(lookingAt)) {
                    System.out.println("looking at " + lookingAt);
                    removeChars(lookingFor,lookingAt);
                }
            }
        }

    }

    public String removeChars(String lookFor, String lookAt) {
        Pattern pattern = Pattern.compile(lookFor);
        Matcher matcher = pattern.matcher(lookAt);
        if (lookFor.length() > 0) {
            if (matcher.find()) {
                int start = matcher.start();
                int end = matcher.end();
                String cutPart = lookFor.substring(start,end);
                lookFor = lookFor.replace(cutPart, "");
                System.out.println("removed version "+cutPart);
            }
        }
        return lookFor;
    }

    public boolean matchFinder(String lookFor, String lookAt) {
        Pattern pattern = Pattern.compile(lookFor);
        Matcher matcher = pattern.matcher(lookAt);
        if (matcher.find()) {
            System.out.println("starts at " + matcher.start() + " ends at " + matcher.end());
        }
        return matcher.find();
    }

    public LinkedList<String> removeDuplicates(LinkedList<String> list, String lookFor) {

        List justList = list.stream().filter(e -> !e.equals(lookFor)).toList();
        return new LinkedList<>(justList);
    }
}