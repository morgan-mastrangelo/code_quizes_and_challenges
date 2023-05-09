package com.rag.advent.day_6;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class PartOne {
    File file = new File("src/com/rag/advent/day_6/input.txt");
    static int fourStreamUniqueIndex = 0;
    String givenDataStream;

    public String getGivenDataStream() {

        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                return scanner.nextLine();

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();

        }
        return  "Error";
    }

    public void testSample2() {
        String dataStreams = this.getGivenDataStream();
        Character nextStreamOne = null;
        Character nextStreamTwo = null;
        Character nextStreamThree = null;

        for (int i = 0; i < dataStreams.length(); i++) {
            Set<Character> set = new HashSet();
            char stream = dataStreams.charAt(i);
            Map<Integer, Character> indexChacterHolder = new HashMap<>();
            int streamCharacterCount = 1;
            set.add(stream);

            for (int j = i + 1; j < (i + 1) + 3; j++) {

                if (streamCharacterCount == 1) {
                    if (j < dataStreams.length()) {
                        nextStreamOne = dataStreams.charAt(j);
                        indexChacterHolder.put(j + 1, nextStreamOne);
                        System.out.println("current character is " + stream + " first character is " + nextStreamOne);
                    } else {
                        nextStreamOne = null;

                    }
                }
                if (streamCharacterCount == 2) {
                    if (j < dataStreams.length()) {
                        nextStreamTwo = dataStreams.charAt(j);
                        indexChacterHolder.put(j + 1, nextStreamTwo);
                        System.out.println("current character is " + stream + " first character is " + nextStreamTwo);
                    } else {
                        nextStreamTwo = null;
                    }
                }
                if (streamCharacterCount == 3) {
                    if (j < dataStreams.length()) {
                        nextStreamThree = dataStreams.charAt(j);
                        indexChacterHolder.put(j + 1, nextStreamThree);
                        System.out.println("current character is " + stream + " first character is " + nextStreamThree);
                    } else {
                        nextStreamThree = null;
                    }
                }
                if (streamCharacterCount == 4) {

                    streamCharacterCount = 1;
                }
                System.out.println("stream character count is " + streamCharacterCount);
                streamCharacterCount++;

//
            }
            System.out.println("----------------");
            System.out.println(nextStreamOne + " " + nextStreamTwo + " " + nextStreamThree);
            if (nextStreamOne != null) set.add(nextStreamOne);
            if (nextStreamTwo != null) set.add(nextStreamTwo);
            if (nextStreamThree != null) set.add(nextStreamThree);
            if (set.size() == 4) {
                System.out.println("four unique stream found ");
                System.out.println(set);
                System.out.println("++++++++++++ ++++++++++ index map ");

                for (Map.Entry<Integer, Character> map : indexChacterHolder.entrySet()
                ) {

                    System.out.print(map.getKey() + " " + " chacter is " + map.getValue() + " ");
                    PartOne.setFourStreamMatchingUniqueIndex(map.getKey());
                }
                System.out.println("\n");
                break;
            }

        }
    }

    public static void setFourStreamMatchingUniqueIndex(int i) {
        fourStreamUniqueIndex = i;

    }

    public static void main(String[] args) {
        PartOne pt = new PartOne();
        pt.testSample2();
        System.out.println("final answer ");
        System.out.println("Unique index is " + fourStreamUniqueIndex);
    }
}
