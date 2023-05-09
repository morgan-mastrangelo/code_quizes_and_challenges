package com.rag.leet_code.concatenated_words.attempt_3;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {
    public static void main(String[] args) {
        String[] testCase_1 = {"a", "b", "ab", "abc"};
        String[] testCase_2 = {"cat", "cats", "catsdogcats", "dog", "dogcatsdog", "hippopotamuses", "rat", "ratcatdogcat"};
        Solution solution = new Solution();
        solution.findAllConcatenatedWordsInADict(testCase_2);
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


        return list;
    }

    public LinkedList<String> compareLists(LinkedList<String> list1, LinkedList<String> list2) {
        LinkedList<String> myList = new LinkedList<>(list1);
        myList.retainAll(list2);
        Collections.sort(myList);
        System.out.println(myList);
        return myList;
    }

    public LinkedList<String> finalListComparison(LinkedList<String> list) {
        LinkedList<String> myList = new LinkedList<>();
        for (String lookingFor : list
        ) {
            System.out.println("going " + lookingFor);
            for (String lookingAt : list
            ) {
                if (!lookingFor.equals(lookingAt)) {
                    if (matchFinder(lookingFor, lookingAt)) {
                        System.out.println(lookingFor + " found in " + lookingAt);
                        myList.add(lookingFor);
                        break;
                    }
                }
            }
        }
        System.out.println("Final comparison one ");
        System.out.println(myList);
        return list;
    }

    public boolean matchFinder(String lookFor, String lookAt) {
        Pattern pattern = Pattern.compile(lookFor);
        Matcher matcher = pattern.matcher(lookAt);
        return matcher.find();
    }

    public LinkedList<String> removeDuplicates(LinkedList<String> list, String lookFor) {

        List justList = list.stream().filter(e -> !e.equals(lookFor)).toList();
        return new LinkedList<>(justList);
    }
}