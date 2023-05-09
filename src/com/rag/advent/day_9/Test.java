package com.rag.advent.day_9;

import java.math.BigInteger;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Test {
    public static void main(String[] args) {
        Test t = new Test();
        t.posH = 1;
        t.posT = 1;

//        t.moveH("R 4");
//        t.moveH("U 4");
//        t.moveH("L 3");
//        t.moveH("D 1");
//        t.moveH("R 4");
//        t.moveH("D 1");
//        t.moveH("L 5");
//        t.moveH("R 2");
        t.doStuff(Util.inputFile());
        System.out.println(t.visitedPoints);
        long total = t.visitedPoints.stream().count();
        long nValues = t.visitedPoints.stream().filter(integer -> integer < 0).count();
        long pValues = t.visitedPoints.stream().filter(integer -> integer > 0).count();
        System.out.println(nValues);
        System.out.println(pValues);
        System.out.println(nValues+pValues);
    }

    public void doStuff(List<String> inst) {
        for (String s : inst) {
            this.moveH(s);
        }
    }

    int posH = 1;
    int posT = 1;
    int posHBeforeMove = 1;

    String direction = "";
    Set<Integer> visitedPoints = new HashSet<>();

    public void moveH(String direction) {
        int steps = Integer.parseInt(direction.split(" ")[1]);
        String moveTo = direction.split(" ")[0];
        this.posHBeforeMove = posH;
        this.direction = moveTo;
        if (moveTo.equals("R")) {
            posH = posH + steps;
        } else if (moveTo.equals("L")) {
            posH = posH - steps;
        } else if (moveTo.equals("U")) {
            posH = posH + (steps * 6);
        } else if (moveTo.equals("D")) {
            posH = posH - (steps * 6);
        }
        moveT();

        System.out.println("-------------");
    }

    public void tailTrailsSameRow(int currentPos, int movingPosition) {
        if (currentPos - movingPosition > 0) {
            for (int i = currentPos; i >= movingPosition; i--) {
                System.out.println("moving from " + i);
                visitedPoints.add(i);
            }
        }
        if (currentPos - movingPosition < 0) {
            for (int i = currentPos; i <= movingPosition; i++) {
                System.out.println("moving from " + i);
                visitedPoints.add(i);
            }
        }

    }

    public void tailTrailsSameCol(int currentPos, int movingPosition) {
        if (currentPos - movingPosition > 0) {
            for (int i = currentPos; i >= movingPosition; i -= 6) {
                System.out.println("moving from " + i);
                visitedPoints.add(i);
            }
        }
        if (currentPos - movingPosition < 0) {
            for (int i = currentPos; i <= movingPosition; i += 6) {
                System.out.println("moving from " + i);
                visitedPoints.add(i);
            }
        }

    }

    public void moveT() {
        //current row and column of Tail
        int rowT = rowFinder(posT);
        int colT = colFinder(posT);

        //current row and column of Head
        int rowH = rowFinder(posH);
        int colH = colFinder(posH);
        System.out.println("current row and column of head is " + rowH + " " + colH);
        System.out.println("current row and column of tail is " + rowT + " " + colT);

        if (rowH == rowT) {
            System.out.println("both are in same row ");
            if (posH - posT > 1 || posT - posH > 1) {
                int currentPos = posT;
                if (this.direction.equals("R")) {
                    posT = posH - 1;
                } else if (this.direction.equals("L")) {
                    posT = posH + 1;
                }
                tailTrailsSameRow(currentPos, posT);
                System.out.println("movable");
                this.trackPositions();
            }
        }

        if (colH == colT) {
            this.trackPositions();
            System.out.println("both are in same column ");

            if (posH - posT > 6 || posT - posH > 6) {

                int currentPos = posT;
                if (this.direction.equals("U")) {
                    posT = posH - 6;
                } else if (this.direction.equals("D")) {
                    posT = posH + 6;
                }
                tailTrailsSameCol(currentPos, posT);
                System.out.println("movable");
                this.trackPositions();
            }
        }

        if (colH != colT && rowH != rowT) {
            int rowDirrerence = (rowFinder(posH) - rowFinder(posT));
            int colDirrence = colFinder(posH) - colFinder(posT);
            trackPositions();
            rowColUpdate();
            if (this.direction.equals("U") || this.direction.equals("D")) {
                if (rowDirrerence > 1 || rowDirrerence < -1) {
                    int currentPos = 0;
                    if (this.direction.equals("U")) {
                        posT = posHBeforeMove + 6;
                        currentPos = posT;
                        posT = posH - 6;
                    } else if (this.direction.equals("D")) {
                        posT = posHBeforeMove - 6;
                        currentPos = posT;
                        posT = posH + 6;
                    }
                    tailTrailsSameCol(currentPos, posT);
                }
                System.out.println("row difference is " + (rowFinder(posH) - rowFinder(posT)));
            }
            if (this.direction.equals("L") || this.direction.equals("R")) {
                System.out.println("direction is " + direction);
                System.out.println("Col difference is " + colDirrence);
                if (colDirrence > 1 || colDirrence < -1) {
                    int currentPos = posT;
                    if (this.direction.equals("R")) {
                        if (rowDirrerence > 0) {


                            posT = posHBeforeMove + 1;
                        }
                        if (rowDirrerence < 0) {
                            System.out.println("T is on the top");
                            posT = posHBeforeMove + 2;
                        }
//                            posT = posHBeforeMove + 1;
                        System.out.println("moved h position was " + posHBeforeMove);
                        currentPos = posT;
                        posT = posH - 1;
                    } else if (this.direction.equals("L")) {
                        System.out.println("moved h position was " + posHBeforeMove);
                        posT = posHBeforeMove - 1;
                        currentPos = posT;
                        posT = posH + 1;
                    }
                    tailTrailsSameRow(currentPos, posT);
                }
            }


            this.trackPositions();

        }

    }

    public static int colFinder(int position) {
        int remainder = position % 6;
        if (remainder == 0) {
            remainder = 6;
        }
        return remainder;
    }

    //gi
    public static int rowFinder(int position) {
        double divideValue = position / Double.valueOf(6);
        int row = 0;
        if (divideValue >= 0 && divideValue <= 1) {
            row = 1;
        } else if (divideValue > 1 && divideValue <= 2) {
            row = 2;
        } else if (divideValue > 2 && divideValue <= 3) {
            row = 3;
        } else if (divideValue > 3 && divideValue <= 4) {
            row = 4;
        } else if (divideValue > 4 && divideValue <= 5) {
            row = 5;
        }
        return row;
    }

    public void trackPositions() {

        System.out.println("Pos H " + this.posH + " Pos T " + this.posT);

    }

    public void rowColUpdate() {
        System.out.println("pos H row " + rowFinder(posH) + " pos H col " + colFinder(posH));
        System.out.println("pos T row " + rowFinder(posT) + " pos T col " + colFinder(posT));
    }
}
