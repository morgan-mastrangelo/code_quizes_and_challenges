package com.rag.advent.day_2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Part_2 {
    public static void main(String[] args) {
        File input = new File("src/com/rag/advent/day_2/input.txt");
        try {
            Scanner myReader = new Scanner(input);
            int total_score = 0;
            while (myReader.hasNextLine()) {
                String both_responese = myReader.nextLine();
                String opponent_element = both_responese.split(" ")[0];
                String my_element = both_responese.split(" ")[1];

                //in opponents response
                //A = Rock, B = Paper, C = Scissor
                //in my resonse
                //X = Rock, Y = Paper, Z = Scissor
                int myScore = 0;
                int marks_for_the_result = 0;

                int win = 6;
                int draw = 3;
                int lose = 0;

                //marks for the object
                int marks_for_rock = 1;
                int marks_for_paper = 2;
                int marks_for_scissor = 3;



                //for that my fixed responses would be

                //X means I have to lose so I have to throw to lose
                //Y means I have to draw So I have to throw to draw
                //Z means I have to win so I have to throw to win
                if (my_element.equals("X")) {
                    //losing situation
                    marks_for_the_result = lose;
                    if (opponent_element.equals("A")) {
                        //thrown rock,I threw scissor;

                       myScore = marks_for_the_result + marks_for_scissor;
                    }
                    if (opponent_element.equals("B")) {
                        //throws paper, I threw rock
                        myScore = marks_for_the_result+ marks_for_rock;
                    }
                    if (opponent_element.equals("C")) {
                        //throws scissor, I threw paper
                        myScore = marks_for_the_result+ marks_for_paper;


                    }

                }
                if (my_element.equals("Y")) {
                    //draw situation
                    marks_for_the_result = draw;


                    if (opponent_element.equals("A")) {
                        //thrown rock,I threw rock;
                        myScore = marks_for_the_result + marks_for_rock;
                    }
                    if (opponent_element.equals("B")) {
                        //throws paper, I threw paper
                        myScore = marks_for_the_result+ marks_for_paper;
                    }
                    if (opponent_element.equals("C")) {
                        //throws scissor, I threw scissor
                        myScore = marks_for_the_result+ marks_for_scissor;


                    }
                }
                if (my_element.equals("Z")) {
                    //win situation
                    marks_for_the_result = win;


                    if (opponent_element.equals("A")) {
                        //thrown rock,I threw paper;
                        myScore = marks_for_the_result +  marks_for_paper;
                    }
                    if (opponent_element.equals("B")) {
                        //throws paper, I threw scissor
                        myScore = marks_for_the_result+ marks_for_scissor;
                    }
                    if (opponent_element.equals("C")) {
                        //throws scissor, I threw rock
                        myScore = marks_for_the_result+ marks_for_rock;


                    }

                }

                total_score += myScore;

            }
            System.out.println(total_score);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}

