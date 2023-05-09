package com.rag.leet_code.concatenated_words.attempt_1;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class Test1 {
    public static void main(String[] args) {
        Solution s = new Solution();
        String[] words = {"cat","cats","catsdogcats","dog","dogcatsdog","hippopotamuses","rat","ratcatdogcat"};
        s.findAllConcatenatedWordsInADict(words);
    }
}


class Solution {
    List<String> list;
     LinkedList<String> concList ;
     LinkedList<String> myList = new LinkedList();
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        String previousWord="";
        String currentWord="";
        list = Arrays.asList(words);
        concList =new LinkedList<String>(list);
        for(int i =0;i<list.size();i++){
            String word = list.get(i);
            sout("Current word is "+word);
            for(int j=0;j<list.size();j++){
                if(i!=j){
                    String loopingWord = list.get(j);


                    if(matchFinder(word,loopingWord)){
                        concList.set(i,"boom");
                        break;
                    }else{
                        sout(loopingWord);
                        System.out.println(matchFinder(word,loopingWord));

                    }
                }
            }
            sout("--------");
        }
        sout("boom boom ");
        removeElementsByWord("boom");

        sout("--------");
        sout("--------");
        return doCompareLists();
        // myList.forEach(e->System.out.println(e));

    }
    public  void sout(String string){

        System.out.println(string);
    }
    public  void removeFromList(int i){
        concList.remove(i);
    }
    public  void removeElementsByWord(String word){
        List tlist = concList.stream().filter(e->!e.equals(word)).toList();
        concList = new LinkedList<String>(tlist);
    }

    public  LinkedList<String> doCompareLists(){

        for(String conCword:concList){
            for(String word:list){
                if(!word.equals(conCword)){

                    if(matchFinder(word,conCword)){
                        myList.add(conCword);
                    }
                }
            }
        }
        sout("conc words are ");
        concList.stream().forEach(e->System.out.println(e));


        Set<String> set = new HashSet();
        myList.forEach(e->set.add(e));
        LinkedList<String> s = new LinkedList();


        System.out.println("from set ");
        set.stream().forEach(e->System.out.println(e));
        System.out.println(set.size());
        set.stream().forEach(e->s.add((e)));
        Collections.sort(s);
        System.out.println("after sorting");
         s.stream().forEach(e->System.out.println(e));
        return s;
    }

//    public static LinkedList<String> sortAlphabetic (){
//
//    }
    public  boolean matchFinder(String lookFor,String word){
        Pattern pattern = Pattern.compile(lookFor);
        Matcher matcher = pattern.matcher(word);
        return matcher.find();
    }
}