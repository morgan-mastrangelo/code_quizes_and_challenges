package com.rag.advent.day_6;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class PartTwo {
    File file = new File("src/com/rag/advent/day_6/input.txt");
    static int firstMessageMarkerIndex = 0;
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
        return "Error";
    }

    public void test() {
        String dataStreams = getGivenDataStream();


        for (int i = 0; i < dataStreams.length(); i++) {
            Set<Character> set = new HashSet();
            char stream = dataStreams.charAt(i);
            set.add(stream);

            for (int j = i + 1; j < (i + 1) + 13; j++) {
                if (j < dataStreams.length()) {
                    set.add(dataStreams.charAt(j));
                }
//
            }

            if (set.size() == 14) {
                System.out.println("YES");
                System.out.println(set);
                PartTwo.setFourStreamMatchingUniqueIndex(i+1+13);
                break;

            }

        }
    }

    public static void setFourStreamMatchingUniqueIndex(int i) {
        firstMessageMarkerIndex = i;

    }

    public static void main(String[] args) {
        PartTwo pt = new PartTwo();
        pt.test();
        System.out.println("final answer ");
        System.out.println(firstMessageMarkerIndex);

    }
}
