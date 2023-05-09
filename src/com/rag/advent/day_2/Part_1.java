package com.rag.advent.day_2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Part_1 {
    public static void main(String[] args) {
        File input = new File("src/com/rag/advent/day_2/input.txt");
        try {
            Scanner myReader = new Scanner(input);
            int total_score = 0;
            while (myReader.hasNextLine()) {
                String both_responese = myReader.nextLine();
                String opponent_element = both_responese.split(" ")[0];
                String my_element = both_responese.split(" ")[1];
                System.out.println("opponent response is " + opponent_element + " My resonse is " + my_element);

                //in opponents response
                //A = Rock, B = Paper, C = Scissor
                //in my resonse
                //X = Rock, Y = Paper, Z = Scissor
                int myScore = 0;
                int marks_for_rock = 1;
                int marks_for_paper = 2;
                int marks_for_scissor = 3;


                //if Opp throws A which means Rock
                //for that my response would be
                if (opponent_element.equals("A") && my_element.equals("X")) {
                    //draw //Rock
                    myScore = 3 + marks_for_rock;
                }
                if (opponent_element.equals("A") && my_element.equals("Y")) {
                    //win //paper
                    myScore = 6 + marks_for_paper;
                }
                if (opponent_element.equals("A") && my_element.equals("Z")) {
                    //lost //scissor
                    myScore = 0 + marks_for_scissor;

                }
                //if Opp throws B which means Paper
                //for that my response would be
                if (opponent_element.equals("B") && my_element.equals("X")) {
                    //lost //Rock
                    myScore = 0 + marks_for_rock;
                }
                if (opponent_element.equals("B") && my_element.equals("Y")) {
                    //draw //paper
                    myScore = 3 + marks_for_paper;
                }
                if (opponent_element.equals("B") && my_element.equals("Z")) {
                    //win //scissor
                    myScore = 6 + marks_for_scissor;

                }
                //if Opp throws C which means Scissor
                //for that my response would be
                if (opponent_element.equals("C") && my_element.equals("X")) {
                    //win //rock
                    myScore = 6 + marks_for_rock;
                }
                if (opponent_element.equals("C") && my_element.equals("Y")) {
                    //lost //paper
                    myScore = 0 + marks_for_paper;
                }
                if (opponent_element.equals("C") && my_element.equals("Z")) {
                    //draw //scissor
                    myScore = 3 + marks_for_scissor;

                }
                total_score += myScore;

            }
            System.out.println(total_score);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}

