package com.rag.leet_code.flood_fill.attempt_2;

public class Solution {
    int screen[][] = {    //the screen dimention and colors
            {1, 1, 1, 1, 1, 1, 1, 1}, {1, 1, 1, 1, 1, 1, 0, 0}, {1, 0, 0, 1, 1, 0, 1, 1}, {1, 2, 2, 2, 2, 0, 1, 0}, {1, 1, 1, 2, 2, 0, 1, 0}, {1, 1, 1, 2, 2, 2, 2, 0}, {1, 1, 1, 1, 1, 2, 1, 1}, {1, 1, 1, 1, 1, 2, 2, 1}};

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.test();
    }

    public void test() {
        System.out.println(screen.length);
    }

    void fill(int x, int y, int prevColor, int newColor) {
        fill(x + 1, y, prevColor, newColor);
        fill(x - 1, y, prevColor, newColor);
        fill(x, y + 1, prevColor, newColor);
        fill(x, y - 1, prevColor, newColor);
    }
}
