package com.rag.leet_code.flood_fill.attempt_4;

public class Solution {
    int[][] image = {
            {1, 1, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1, 1, 0, 0},
            {1, 0, 0, 1, 1, 0, 1, 1},
            {1, 2, 2, 2, 2, 0, 1, 0},
            {1, 1, 1, 2, 2, 0, 1, 0},
            {1, 1, 1, 2, 2, 2, 2, 0},
            {1, 1, 1, 1, 1, 2, 1, 1},
            {1, 1, 1, 1, 1, 2, 2, 1},
    };

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int colorToReplace = image[sr][sc];
        if (colorToReplace == newColor) {
            return image;
        }
        this.doColoring(image, sr, sc, colorToReplace, newColor);
        return image;
    }

    public void doColoring(int[][] image, int r, int c, int colorToReplace, int newColor) {
        if (!isValidPixel(image, r, c)) {
            return;
        }

        if (image[r][c] != colorToReplace) {
            return;
        }

        image[r][c] = newColor;
        doColoring(image, r + 1, c, colorToReplace, newColor);
        doColoring(image, r - 1, c, colorToReplace, newColor);
        doColoring(image, r, c + 1, colorToReplace, newColor);
        doColoring(image, r, c - 1, colorToReplace, newColor);
    }

    public boolean isValidPixel(int[][] image, int x, int y) {
        return x > 0 && y > 0 && x < image.length && y < image[0].length;
    }
}

class Test {
    public static void main(String[] args) {
        Solution s = new Solution();
        s.floodFill(s.image, 4, 4, 3);


        for (int[] x : s.image
        ) {
            for (int y : x
            ) {
                System.out.print(y);
            }
            System.out.println("\n");
        }
    }
}