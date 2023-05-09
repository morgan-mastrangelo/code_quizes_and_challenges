package com.rag.leet_code.number_of_islands.cleaned;

public class Solution {

    public String[][] grid;
    int islandCount = 0;
    public int numIslands(char[][] grid) {
        this.grid = charToStringArray(grid);
        return numIslands(this.grid);

    }
    public int numIslands(String[][] grid) {
        int rowPos = 0;
        int colPos = 0;

        for (String[] row : grid) {

            for (String col : row) {
                doFloodFill("1",rowPos, colPos);
                colPos++;
            }
            colPos = 0;
            System.out.println("\n");
            rowPos++;
        }

        return islandCount;
    }

    public void doFloodFill(String prevValue,int row, int col) {
        if (!isValid(row, col)) {
            return;
        }
        if (grid[row][col].equals("0")) {
            return;
        }

        if (printGridPos(row, col).equals("#")) {
            return;
        }

        if (grid[row][col].equals("1") && prevValue.equals("1")) {
            islandCount++;
        }
        if (grid[row][col].equals("1")) {
            grid[row][col] = "#";
        }
        String pValue = printGridPos(row,col);
        doFloodFill(pValue,row + 1, col);
        doFloodFill(pValue,row, col + 1);
        doFloodFill(pValue,row - 1, col);
        doFloodFill(pValue,row, col - 1);

    }

    public void printGrid() {
        for (String[] row : grid
        ) {
            for (String col : row
            ) {
                System.out.print(col);
            }
            System.out.print("\n");
        }
    }

    public String printGridPos(int row, int col) {
        return grid[row][col];
    }

    public boolean isValid(int row, int col) {
        return row >= 0 && col >= 0 && row < grid.length && col < grid[0].length;
    }
    public String[][] charToStringArray(char[][] charArray){
        String[][] stringArray = new String[charArray.length][charArray[0].length];
        int row = 0;
        for (int i = 0; i < charArray.length; i++) {
            for (int j = 0; j <charArray[0].length ; j++) {
              stringArray[row][j] = String.valueOf(charArray[row][j]);
            }
            row++;
        }
        return stringArray;
    }
}

class Test {
    public static void main(String[] args) {
        Solution s = new Solution();
        s.numIslands(s.grid);
        s.printGrid();
        System.out.println(s.islandCount);
    }
}
