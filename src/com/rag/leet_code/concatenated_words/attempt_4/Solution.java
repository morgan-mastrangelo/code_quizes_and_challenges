package com.rag.leet_code.concatenated_words.attempt_4;

import java.util.*;

public class Solution {
    List<String> testCase1 = new LinkedList<>(Arrays.asList("cat", "cats", "catsdogcats", "dog", "dogcatsdog", "hippopotamuses", "rat", "ratcatdogcat"));
    List<String> testCase2 = new LinkedList<>(Arrays.asList("cat", "dog", "catdog"));
    List<String> testCase3 = new LinkedList<>(Arrays.asList("a", "b", "ab", "abc"));

    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        List<String> list = new LinkedList<>(Arrays.asList(words));
        return findAllConcatenatedWordsInADict(list);
    }

    public List<String> findAllConcatenatedWordsInADict(List<String> words) {
        List<String> list = words;
        Set<String> showCase = new HashSet<>();
        List<String> finalComparison = words;
        for (String word : list) {
            for (String otherWord : list) {
                if (!otherWord.equals(word)) {
                    if (otherWord.contains(word) && otherWord.length() > word.length()) {
                        showCase.add(otherWord);
                    }
                }
            }
            System.out.println("-----------");
        }
        System.out.println("hey " + showCase);
        list = new LinkedList<>(showCase);
        for (String word : showCase
        ) {
            for (String otherWord : showCase
            ) {
                if (!word.equals(otherWord) && otherWord.contains(word) && otherWord.length() >= word.length()) {
                    list.remove(word);
                }
            }
        }

        Set<String> finallySelectedWords = new HashSet<>();
        System.out.println("final list is " + list);
        LinkedList<String> finalList1 = new LinkedList<>();
        if (showCase.size() > 1) {

            for (String word : showCase
            ) {

                for (String otherWord : showCase
                ) {
                    if (!word.equals(otherWord) && otherWord.contains(word) && otherWord.length()>word.length()) {
                        System.out.println("other word "+otherWord+" contains "+word);
                        finalList1.add(word);
                    }
                }
            }
        }else{
            finalList1.addAll(showCase);
        }
        System.out.println("final list 1 is " + finalList1);
        System.out.println("++++++++++++++++++++++");
        System.out.println("Final comparison");
        System.out.println(finalComparison);
        for (String word : finalComparison
        ) {
            String testWordCount = word;
            System.out.println("here test word count is " + testWordCount);

            for (String containWord : finalComparison
            ) {
                if (!containWord.equals(word)) {
                    if (testWordCount.length() > 0 && testWordCount.contains(containWord)) {
                        System.out.println("Selected word is " + containWord);
                        testWordCount = testWordCount.replace(containWord, "");
                        System.out.println("test word count is " + testWordCount);

                    }
                    if (testWordCount.length() == 0) {
                        System.out.println("this is it");
                        finallySelectedWords.add(word);

                    }

                }
            }
            System.out.println("------------");
        }
        System.out.println("Finally selected words are " + finallySelectedWords);
        return list;
    }
}

class Test {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.findAllConcatenatedWordsInADict(solution.testCase3);
    }
}
