package com.rag.advent.day_3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class PartOne {

    public void fileRead(File file) {
        int sum = 0;

        try (Scanner myReader = new Scanner(file)) {
            while (myReader.hasNextLine()) {
                String compartment = myReader.nextLine();
                String separatedCompartment = this.separateCompartments(compartment);
                Set<String> set = this.collectDuplicatedItems(separatedCompartment);
                int total = this.calculateSumofDupliicatedItems(set);
                sum += total;
                if(compartment.equals("PTDNEpUTHQoQUJMHLrErGJyHg89uy71MyuHdNZ")){
                    System.out.println("fond one bro");
                }
            }

            myReader.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        System.out.println(sum);
    }

    public String separateCompartments(String compartment) {
        int separationIndexPoint = compartment.length() / 2;
        String compart1 = compartment.substring(0, separationIndexPoint);
        String compart2 = compartment.substring(separationIndexPoint);
        return compart1 + "," + compart2;
    }

    public Set<String> collectDuplicatedItems(String separatedCompartments) {
        Set<String> set = new TreeSet<>();

        String compart1 = separatedCompartments.split(",")[0];
        String compart2 = separatedCompartments.split(",")[1];
        for (int i = 0; i < compart1.length(); i++) {
            String compartOneItem = Character.toString(compart1.charAt(i));
            for (int j = 0; j < compart2.length(); j++) {
                String compartTwoItem = Character.toString(compart2.charAt(j));
                if (compartTwoItem.equals(compartOneItem)) {
                    set.add(compartTwoItem);

                }
            }
        }
        System.out.println(set);
        //if one apartment has more than one duplicated items
        //compartment => abcdefgABcdeaa
        //so the duplicated items are acde
        //so the set will have [a,c,d,e]
        return set;
    }

    public int calculateSumofDupliicatedItems(Set<String> set) {
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
        Iterator it = set.iterator();
        while (it.hasNext()) {
            String item = it.next().toString();
            for (Map.Entry<String, String> entry : map.entrySet()) {
                if (entry.getKey().equals(item)) {
                    total += Integer.parseInt(entry.getValue());
                }
            }
        }
        return total;

    }

    public static void main(String[] args) {
        File file = new File("src/com/rag/advent/day_3/input.txt");
        PartOne t2 = new PartOne();
        t2.fileRead(file);

    }



}
