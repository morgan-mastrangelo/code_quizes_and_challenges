package com.rag.advent.day_3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class PartTwo {
    public void fileRead(File file) {
        int sum = 0;
        int line = 1;
        Scanner myReader = null;
        Set<Set> compartmentGroups = new LinkedHashSet<>();
        Set<String> compartments = new HashSet<>();
        try {
            myReader = new Scanner(file);
            while (myReader.hasNextLine()) {

                String compartment = myReader.nextLine();
                if (line == 4) {
                    compartments = new HashSet<>();
                    compartments.add(compartment);
                    line = 1;
                } else if (line == 3) {
                    compartmentGroups.add(compartments);
                    compartments.add(compartment);
                } else {
                    compartments.add(compartment);
                }

                line++;
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        myReader.close();
        for (Set compList : compartmentGroups
        ) {
            String compOne;
            String compTwo;
            String compThree;
            LinkedList<String> comps = new LinkedList<>();
            compList.stream().forEach(comp -> comps.add(comp.toString()));

            compOne = comps.get(0);
            compTwo = comps.get(1);
            compThree = comps.get(2);
            Character characterOne = null;

            LinkedList<Character> characterSetOne = new LinkedList<>();
            LinkedList<Character> characterSetTwo = new LinkedList<>();
            LinkedList<Character> characterSetThree = new LinkedList<>();
            for (int i = 0; i < compOne.length(); i++) {
                Character x = compOne.charAt(i);
                for (int j = 0; j < compTwo.length(); j++) {
                    Character y = compTwo.charAt(j);
                    if (y.equals(x)) {
                        characterSetTwo.add(y);
                    }
                }
            }
            for (int i = 0; i < compOne.length(); i++) {
                Character x = compOne.charAt(i);
                for (int j = 0; j < compThree.length(); j++) {
                    Character y = compThree.charAt(j);
                    if (y.equals(x)) {

                        characterSetThree.add(y);
                    }
                }
            }
            for (int i = 0; i < compTwo.length(); i++) {
                Character x = compTwo.charAt(i);
                for (int j = 0; j < compThree.length(); j++) {
                    Character y = compThree.charAt(j);
                    if (y.equals(x)) {
                        characterOne = y;
                        characterSetOne.add(y);
                    }
                }
            }

            for (int i = 0; i < characterSetOne.size(); i++) {
                Character localset = characterSetOne.get(i);
                for (int j = 0; j < characterSetTwo.size(); j++) {
                    Character innerLocalSet = characterSetTwo.get(j);
                    if (innerLocalSet.equals(localset)) {
                        characterOne = innerLocalSet;
                    }
                }
            }


            sum += this.calculateSumofDupliicatedItems(characterOne);

        }

        System.out.println("sum is " + sum);

    }

    public int calculateSumofDupliicatedItems(Character character) {
        Map<String, String> map = new HashMap();

        map.put("a", "1");
        map.put("b", "2");
        map.put("c", "3");
        map.put("d", "4");
        map.put("e", "5");
        map.put("f", "6");
        map.put("g", "7");
        map.put("h", "8");
        map.put("i", "9");
        map.put("j", "10");
        map.put("k", "11");
        map.put("l", "12");
        map.put("m", "13");
        map.put("n", "14");
        map.put("o", "15");
        map.put("p", "16");
        map.put("q", "17");
        map.put("r", "18");
        map.put("s", "19");
        map.put("t", "20");
        map.put("u", "21");
        map.put("v", "22");
        map.put("w", "23");
        map.put("x", "24");
        map.put("y", "25");
        map.put("z", "26");
        map.put("A", "27");
        map.put("B", "28");
        map.put("C", "29");
        map.put("D", "30");
        map.put("E", "31");
        map.put("F", "32");
        map.put("G", "33");
        map.put("H", "34");
        map.put("I", "35");
        map.put("J", "36");
        map.put("K", "37");
        map.put("L", "38");
        map.put("M", "39");
        map.put("N", "40");
        map.put("O", "41");
        map.put("P", "42");
        map.put("Q", "43");
        map.put("R", "44");
        map.put("S", "45");
        map.put("T", "46");
        map.put("U", "47");
        map.put("V", "48");
        map.put("W", "49");
        map.put("X", "50");
        map.put("Y", "51");
        map.put("Z", "52");

        int total = 0;


        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (entry.getKey().equals(Character.toString(character))) {
                total += Integer.parseInt(entry.getValue());
            }
        }
        return total;

    }

    public static void main(String[] args) {
        PartTwo t = new PartTwo();
        File file = new File("src/com/rag/advent/day_3/input.txt");
        t.fileRead(file);

    }


}
