package com.rag.leet_code.flood_fill.attempt_3;

public class Solution {
    int[][] screen = {
            {1, 1, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1, 1, 0, 0},
            {1, 0, 0, 1, 1, 0, 1, 1},
            {1, 2, 2, 2, 2, 0, 1, 0},
            {1, 1, 1, 2, 2, 0, 1, 0},
            {1, 1, 1, 2, 2, 2, 2, 0},
            {1, 1, 1, 1, 1, 2, 1, 1},
            {1, 1, 1, 1, 1, 2, 2, 1},
    };
    public int[][] floodFill(int[][] image, int sr, int sc, int replacingColor) {
        int colorToReplace = image[sr][sc];
        if (colorToReplace == replacingColor) {
            return image;
        }
        this.doColoring(image,sr,sc,colorToReplace,replacingColor);
        return image;
    }
    public void doColoring(int[][] image, int r, int c, int ogColor, int newColor) {
        //proceed only if the pixel values are valued
        if (!validPixel(image, r, c)) {
            return;
        }
        //if the current pixel and the original color aren't the same
        //then do not proceed
        if (image[r][c] != ogColor) {
            return;
        }

        //replace the color here
        image[r][c] = newColor;

        doColoring(image, r + 1, c, ogColor, newColor);
        doColoring(image, r - 1, c, ogColor, newColor);
        doColoring(image, r, c + 1, ogColor, newColor);
        doColoring(image, r, c - 1, ogColor, newColor);

    }
    public boolean validPixel(int[][] grid, int x, int y) {
        return x >= 0 && y >= 0 && x < grid.length && y < grid[0].length;
    }
}
class Test{

    public static void main(String[] args) {
        Solution s = new Solution();
        s.floodFill(s.screen, 4, 4, 3);

    }
}