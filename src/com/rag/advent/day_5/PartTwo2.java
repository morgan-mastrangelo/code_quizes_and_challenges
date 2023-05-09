package com.rag.advent.day_5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PartTwo2 {
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
    Logger log = Logger.getLogger(PartTwo2.class.getName());
    public void createStacks() {
        log.setLevel(Level.FINE);
        try (Scanner myScanner = new Scanner(cratebox)) {
            while (myScanner.hasNextLine()) {
                String stackRow = myScanner.nextLine();
                StringBuilder stackRowBuilder = new StringBuilder(stackRow);
                if (stackRow.length() < 35) {
                    int neededCharacters = 35 - stackRow.length();
                    for (int i = 0; i < neededCharacters; i++) {
//                        stackRow += "#";
                        stackRowBuilder.append("#");
                    }

                }
                stackRow = stackRowBuilder.toString();
                stackRow = stackRow.replace(" ", "#");
                log.info(stackRow);
                int index = 1;
                for (int i = 0; i < stackRow.length(); i++) {

                    Character character = stackRow.charAt(i);
                    if (index == 2) {
                        PartTwo2.onlyAllowUpperCaseLetters(character, stackOne);
                    }
                    if (index == 6) {
                        PartTwo2.onlyAllowUpperCaseLetters(character, stackTwo);
                    }
                    if (index == 10) {
                        PartTwo2.onlyAllowUpperCaseLetters(character, stackThree);
                    }
                    if (index == 14) {
                        PartTwo2.onlyAllowUpperCaseLetters(character, stackFour);
                    }
                    if (index == 18) {
                        PartTwo2.onlyAllowUpperCaseLetters(character, stackFive);
                    }
                    if (index == 22) {
                        PartTwo2.onlyAllowUpperCaseLetters(character, stackSix);
                    }
                    if (index == 26) {
                        PartTwo2.onlyAllowUpperCaseLetters(character, stackSeven);
                    }
                    if (index == 30) {
                        PartTwo2.onlyAllowUpperCaseLetters(character, stackEight);
                    }
                    if (index == 34) {
                        PartTwo2.onlyAllowUpperCaseLetters(character, stackNine);
                    }
                    index++;
                }


            }
            //reverse the order of lists
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

    public void testingMoveCrates() {
        String command = "move 2 from 1 to 2";
        int moveCount = Integer.parseInt(command.split(" ")[1]);
//        int fromStack = Integer.parseInt(command.split(" ")[3]);
//        int toStack = Integer.parseInt(command.split(" ")[5]);


        LinkedList<String> movingList = new LinkedList<>();
        LinkedList<String> fromList = null;
        LinkedList<String> toList = null;

        fromList = new LinkedList<>();
        toList = new LinkedList<>();

        toList.add("11");
        toList.add("12");
        toList.add("13");
        toList.add("14");

        fromList.add("1");
        fromList.add("2");
        fromList.add("3");
        fromList.add("4");
        fromList.add("5");
        fromList.add("6");

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
        toList.forEach(item -> System.out.print(item + " "));
        System.out.println("\n");

        fromList.forEach(item -> System.out.print(item + " "));


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
    }

    public static void onlyAllowUpperCaseLetters(Character character, List<String> list) {

        if (!Character.toString(character).equals("#") && !Character.toString(character).equals("[") && !Character.toString(character).equals("]")) {

            list.add(character.toString());
        }
    }

    public static String replaceCharInWords(String word, String replace, int index) {
        return word.substring(0, index) + replace + word.substring(index + 1);
    }

    public static void main(String[] args) {
        PartTwo2 pt = new PartTwo2();
        pt.inputFile();

    }
}
