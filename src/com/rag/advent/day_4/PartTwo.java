package com.rag.advent.day_4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;

public class PartTwo {
    public void doFile() {
        File file = new File("src/com/rag/advent/day_4/input.txt");
        int countOfFullyContainPairs = 0;
        try (Scanner myScanner = new Scanner(file)) {
            while (myScanner.hasNextLine()) {
                String sectionPairList = myScanner.nextLine();
                String pairOne = sectionPairList.split(",")[0];
                String pairTwo = sectionPairList.split(",")[1];
                LinkedList<Integer> pairOneSections = new LinkedList<>();
                int pairOneSectionStart = Integer.parseInt(pairOne.split("-")[0]);
                int pairOneSectionEnd = Integer.parseInt(pairOne.split("-")[1]);

                int pairTwoSectionStart = Integer.parseInt(pairTwo.split("-")[0]);
                int pairTwoSectionEnd = Integer.parseInt(pairTwo.split("-")[1]);

                boolean start = false;
                boolean end = false;

                boolean start2 = false;
                boolean end2 = false;
                for (int i = pairOneSectionStart; i <= pairOneSectionEnd; i++) {
                    if (i == pairTwoSectionStart) {
                        start = true;
                    }
                    if (i == pairTwoSectionEnd) {
                        start = true;
                    }
                }
                if (start) {
                    countOfFullyContainPairs++;
                }else{
                    for (int i = pairTwoSectionStart; i <= pairTwoSectionEnd; i++) {
                        if (i == pairOneSectionStart) {
                            start2 = true;
                        }
                        if (i == pairOneSectionEnd) {
                            start2 = true;
                        }
                    }
                    if(start2){
                        countOfFullyContainPairs++;
                    }
                }


            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        System.out.println(countOfFullyContainPairs);
    }

    public static void main(String[] args) {
        PartTwo p = new PartTwo();
        p.doFile();
    }
}
