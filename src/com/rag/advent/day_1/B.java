package com.rag.advent.day_1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        File myObj = new File("src/com/rag/advent/day_1/puzzle_input.txt");
        try {
            Scanner myReader = new Scanner(myObj);
            LinkedList<Integer> caloryList = new LinkedList<>();
            LinkedList<LinkedList> each_elk_calory = new LinkedList<>();
            LinkedList<Integer> first_elk_calory_list = new LinkedList<>();
            int total_spaces = 0;
            while (myReader.hasNextLine()) {
                String calory = myReader.nextLine();


                if (!calory.equals("")) {
                    first_elk_calory_list.add(Integer.parseInt(calory));
                }
                if (calory.equals("")) {
                    total_spaces++;
                    each_elk_calory.add(first_elk_calory_list);
                    first_elk_calory_list = new LinkedList<>();

                }


            }


            int highest_total = 0;
            int second_highest_total = 0;
            int third_highest_total = 0;
            for (int i = 0; i < each_elk_calory.size(); i++) {
                LinkedList<Integer> elk_calory_list = each_elk_calory.get(i);
                int current_total = 0;
                for (int j = 0; j < elk_calory_list.size(); j++) {
                    current_total += elk_calory_list.get(j);
                }

                if (current_total > highest_total) {
                    highest_total = current_total;
                }

            }
            for (int i = 0; i < each_elk_calory.size(); i++) {
                LinkedList<Integer> elk_calory_list = each_elk_calory.get(i);
                int current_total = 0;
                for (int j = 0; j < elk_calory_list.size(); j++) {
                    current_total += elk_calory_list.get(j);
                }

                if (current_total < highest_total && current_total>second_highest_total) {
                    second_highest_total = current_total;
                }

            }
            for (int i = 0; i < each_elk_calory.size(); i++) {
                LinkedList<Integer> elk_calory_list = each_elk_calory.get(i);
                int current_total = 0;
                for (int j = 0; j < elk_calory_list.size(); j++) {
                    current_total += elk_calory_list.get(j);
                }

                if (current_total < highest_total && current_total<second_highest_total && current_total>third_highest_total) {
                    third_highest_total = current_total;
                }

            }
            System.out.println("highest total is "+highest_total);
            System.out.println("second highest total is "+second_highest_total);
            System.out.println("third highest total is "+third_highest_total);
            System.out.println("so the total is "+(highest_total+second_highest_total+third_highest_total));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
}
