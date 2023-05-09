package com.rag.advent.day_5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Set;

public class PartTwo {
    LinkedList<String> stackOne = new LinkedList<>();
    LinkedList<String> stackTwo = new LinkedList<>();
    LinkedList<String> stackThree = new LinkedList<>();
    LinkedList<String> stackFour = new LinkedList<>();
    LinkedList<String> stackFive = new LinkedList<>();
    LinkedList<String> stackSix = new LinkedList<>();
    LinkedList<String> stackSeven = new LinkedList<>();
    LinkedList<String> stackEight = new LinkedList<>();
    LinkedList<String> stackNine = new LinkedList<>();
    File cratebox = new File("src/com/rag/advent/day_5/cratebox2.txt");
    File input =  new File("src/com/rag/advent/day_5/input2.txt");
    public void createStacks() {
        Set<String> set = new HashSet<>();
        try (Scanner myScanner = new Scanner(cratebox)) {
            while (myScanner.hasNextLine()) {
                String stackRow = myScanner.nextLine();

                if (stackRow.length() < 35) {
                    int neededCharacters = 35 - stackRow.length();
                    for (int i = 0; i < neededCharacters; i++) {
                        stackRow += "#";
                    }

                }
                stackRow = stackRow.replace(" ", "#");
                System.out.println(stackRow);
                int index = 1;
                for (int i = 0; i < stackRow.length(); i++) {

                    Character character = stackRow.charAt(i);
                    if (index == 2) {
                        PartTwo.onlyAllowUpperCaseLetters(character, stackOne);
                    }
                    if (index == 6) {
                        PartTwo.onlyAllowUpperCaseLetters(character, stackTwo);
                    }
                    if (index == 10) {
                        PartTwo.onlyAllowUpperCaseLetters(character, stackThree);
                    }
                    if (index == 14) {
                        PartTwo.onlyAllowUpperCaseLetters(character, stackFour);
                    }
                    if (index == 18) {
                        PartTwo.onlyAllowUpperCaseLetters(character, stackFive);
                    }
                    if (index == 22) {
                        PartTwo.onlyAllowUpperCaseLetters(character, stackSix);
                    }
                    if (index == 26) {
                        PartTwo.onlyAllowUpperCaseLetters(character, stackSeven);
                    }
                    if (index == 30) {
                        PartTwo.onlyAllowUpperCaseLetters(character, stackEight);
                    }
                    if (index == 34) {
                        PartTwo.onlyAllowUpperCaseLetters(character, stackNine);
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

    public LinkedList<String> reverseLinkedList(LinkedList<String> list) {
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


        LinkedList<String> movingList = new LinkedList<>();
        LinkedList<String> fromList = null;
        LinkedList<String> toList = null;

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
        }

        toList.stream().forEach(item -> System.out.print(item + " "));

        System.out.println("\n");

        fromList.stream().forEach(item -> System.out.print(item + " "));
        System.out.println("\n");

        System.out.println("------");

        for (int i = 0; i < moveCount; i++) {
            System.out.println("moving crate is " + fromList.get(0));
            movingList.add(fromList.get(0));
            fromList.remove(0);
        }
        for (int i = 0; i < moveCount; i++) {
            toList.add(movingList.get(i));
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
            throw new RuntimeException(e);
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
    }

    public static void onlyAllowUpperCaseLetters(Character character, LinkedList<String> list) {

        if (!Character.toString(character).equals("#") && !Character.toString(character).equals("[") && !Character.toString(character).equals("]")) {

            list.add(character.toString());
        }
    }

    public static String replaceCharInWords(String word, String replace, int index) {
        return word.substring(0, index) + replace + word.substring(index + 1);
    }

    public static void main(String[] args) {
        PartTwo pt = new PartTwo();
        pt.inputFile();
        LinkedList<String> list = new LinkedList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("5");
        list.add("6");

    }
}
