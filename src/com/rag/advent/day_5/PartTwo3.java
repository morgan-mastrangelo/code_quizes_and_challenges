package com.rag.advent.day_5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PartTwo3 {
    List<String> stackOne = new LinkedList<>();
    List<String> stackTwo = new LinkedList<>();
    List<String> stackThree = new LinkedList<>();
    List<String> stackFour = new LinkedList<>();
    List<String> stackFive = new LinkedList<>();
    List<String> stackSix = new LinkedList<>();
    List<String> stackSeven = new LinkedList<>();
    List<String> stackEight = new LinkedList<>();
    List<String> stackNine = new LinkedList<>();
    File cratebox = new File("src/com/rag/advent/day_5/cratebox.txt");
    File input = new File("src/com/rag/advent/day_5/input.txt");
    String finalAnswer = "";
    public void createStacks() {
        try (Scanner myScanner = new Scanner(cratebox)) {
            while (myScanner.hasNextLine()) {
                String stackRow = myScanner.nextLine();
                StringBuilder stackRowBuilder = new StringBuilder(stackRow);
                if (stackRow.length() < 35) {
                    int neededCharacters = 35 - stackRow.length();
                    for (int i = 0; i < neededCharacters; i++) {
                        stackRowBuilder.append("#");
                    }

                }
                stackRow = stackRowBuilder.toString();
                stackRow = stackRow.replace(" ", "#");
                System.out.println(stackRow);
                int index = 1;
                for (int i = 0; i < stackRow.length(); i++) {

                    Character character = stackRow.charAt(i);
                    if (index == 2) {
                        PartTwo3.onlyAllowUpperCaseLetters(character, stackOne);
                    }
                    if (index == 6) {
                        PartTwo3.onlyAllowUpperCaseLetters(character, stackTwo);
                    }
                    if (index == 10) {
                        PartTwo3.onlyAllowUpperCaseLetters(character, stackThree);
                    }
                    if (index == 14) {
                        PartTwo3.onlyAllowUpperCaseLetters(character, stackFour);
                    }
                    if (index == 18) {
                        PartTwo3.onlyAllowUpperCaseLetters(character, stackFive);
                    }
                    if (index == 22) {
                        PartTwo3.onlyAllowUpperCaseLetters(character, stackSix);
                    }
                    if (index == 26) {
                        PartTwo3.onlyAllowUpperCaseLetters(character, stackSeven);
                    }
                    if (index == 30) {
                        PartTwo3.onlyAllowUpperCaseLetters(character, stackEight);
                    }
                    if (index == 34) {
                        PartTwo3.onlyAllowUpperCaseLetters(character, stackNine);
                    }
                    index++;
                }


            }
            stackOne = this.reverseLinkedList(stackOne);
            stackTwo = this.reverseLinkedList(stackTwo);
            stackThree = this.reverseLinkedList(stackThree);
            stackFour = this.reverseLinkedList(stackFour);
            stackFive = this.reverseLinkedList(stackFive);
            stackSix = this.reverseLinkedList(stackSix);
            stackSeven = this.reverseLinkedList(stackSeven);
            stackEight = this.reverseLinkedList(stackEight);
            stackNine = this.reverseLinkedList(stackNine);
            System.out.println("----------------");
            System.out.println("First stack");
            stackOne.stream().forEach(stacks -> System.out.print(stacks + " "));
            System.out.println("\n");
            System.out.println("Second stack");
            stackTwo.stream().forEach(stacks -> System.out.print(stacks + " "));
            System.out.println("\n");

            System.out.println("Third stack");
            stackThree.stream().forEach(stacks -> System.out.print(stacks + " "));
            System.out.println("\n");

//            System.out.println("Four stack");
//            stackFour.stream().forEach(stacks -> System.out.print(stacks+" "));
//            System.out.println("\n");
            System.out.println("--------------");
            System.out.println("End of stackcreation");

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public List<String> reverseLinkedList(List<String> list) {
        LinkedList<String> reverseList = new LinkedList<>();
        for (int i = list.size() - 1; i >= 0; i--) {
            System.out.println(list.get(i));
            reverseList.add(list.get(i));
        }

        return reverseList;
    }

    public void moveCrates(String command) {

        int moveCount = Integer.parseInt(command.split(" ")[1]);
        int fromStack = Integer.parseInt(command.split(" ")[3]);
        int toStack = Integer.parseInt(command.split(" ")[5]);


        List<String> movingList = new LinkedList<>();
        List<String> fromList = null;
        List<String> toList = null;

        switch (fromStack) {
            case 1:
                fromList = stackOne;
                break;
            case 2:
                fromList = stackTwo;
                break;
            case 3:
                fromList = stackThree;
                break;
            case 4:
                fromList = stackFour;
                break;
            case 5:
                fromList = stackFive;
                break;
            case 6:
                fromList = stackSix;
                break;
            case 7:
                fromList = stackSeven;
                break;
            case 8:
                fromList = stackEight;
                break;
            case 9:
                fromList = stackNine;
                break;
            default:
                fromList= null;
        }
        switch (toStack) {
            case 1:
                toList = stackOne;
                break;
            case 2:
                toList = stackTwo;
                break;
            case 3:
                toList = stackThree;
                break;
            case 4:
                toList = stackFour;
                break;
            case 5:
                toList = stackFive;
                break;
            case 6:
                toList = stackSix;
                break;
            case 7:
                toList = stackSeven;
                break;
            case 8:
                toList = stackEight;
                break;
            case 9:
                toList = stackNine;
                break;
            default:
                toList = null;

        }

        toList.stream().forEach(item -> System.out.print(item + " "));

        System.out.println("\n");

        fromList.stream().forEach(item -> System.out.print(item + " "));
        System.out.println("\n");

        System.out.println("------");

        for (int i = 0; i < moveCount; i++) {
            System.out.println("moving crate is " + fromList.get(fromList.size() - 1));
            movingList.add(fromList.get(fromList.size() - 1));
            fromList.remove(fromList.size() - 1);
        }
        for (int i = 0; i < moveCount; i++) {
            toList.add(movingList.get(movingList.size() - 1 - i));
        }
        toList.stream().forEach(item -> System.out.print(item + " "));
        System.out.println("\n");

        fromList.stream().forEach(item -> System.out.print(item + " "));


    }


    public void inputFile() {
        File file = this.input;

        try {
            Scanner myScanner = new Scanner(file);
            this.createStacks();
            while (myScanner.hasNextLine()) {
                String command = myScanner.nextLine();

                moveCrates(command);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
//            throw new RuntimeException(e);
        }

        System.out.println("\n");
        System.out.println("====================++++++++++++++++++__________________----------------");

        stackOne.stream().forEach(stacks -> System.out.print(stacks + " "));
        System.out.println("\n");
        stackTwo.stream().forEach(stacks -> System.out.print(stacks + " "));
        System.out.println("\n");
        stackThree.stream().forEach(stacks -> System.out.print(stacks + " "));
        System.out.println("\n");
        stackFour.stream().forEach(stacks -> System.out.print(stacks + " "));
        System.out.println("\n");
        stackFive.stream().forEach(stacks -> System.out.print(stacks + " "));
        System.out.println("\n");
        stackSix.stream().forEach(stacks -> System.out.print(stacks + " "));
        System.out.println("\n");
        stackSeven.stream().forEach(stacks -> System.out.print(stacks + " "));
        System.out.println("\n");
        stackEight.stream().forEach(stacks -> System.out.print(stacks + " "));
        System.out.println("\n");
        stackNine.stream().forEach(stacks -> System.out.print(stacks + " "));
        System.out.println("\n");

        StringBuilder sb = new StringBuilder();
        sb.append(stackOne.get(stackOne.size()-1));
        sb.append(stackTwo.get(stackTwo.size()-1));
        sb.append(stackThree.get(stackThree.size()-1));
        sb.append(stackFour.get(stackFour.size()-1));
        sb.append(stackFive.get(stackFive.size()-1));
        sb.append(stackSix.get(stackSix.size()-1));
        sb.append(stackSeven.get(stackSeven.size()-1));
        sb.append(stackEight.get(stackEight.size()-1));
        sb.append(stackNine.get(stackNine.size()-1));
        finalAnswer = sb.toString();
    }

    public static void onlyAllowUpperCaseLetters(Character character, List<String> list) {

        if (!Character.toString(character).equals("#") && !Character.toString(character).equals("[") && !Character.toString(character).equals("]")) {

            list.add(character.toString());
        }
    }



    public static void main(String[] args) {
        PartTwo3 pt = new PartTwo3();
        pt.inputFile();
        System.out.println("Final answer");
        System.out.println(pt.finalAnswer);

    }
}
