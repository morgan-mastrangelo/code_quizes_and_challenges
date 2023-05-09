package com.rag.leet_code.flood_fill.deborder;

public class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int source = image[sr][sc];
        // stop if it is the same color
        if (source == color) return image;

        // fill the grid
        dfs(image, sr, sc, source, color);
        return image;

    }

    // not a 'good' name but DFS is a good dummyname
    public void dfs(int[][] grid, int r, int c, int source, int target) {
        if (!contains(grid, r, c)) return;  // return if point is outside grid
        if (grid[r][c] != source) return; // stop if not the source color
        grid[r][c] = target;

        // each value in move4 =  {row, col}
        for (var move : moves4) {
            dfs(grid, r + move[0], c + move[1], source, target);
        }

    }


    // !!save this to re-use later;
    int[][] moves4 = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};


    // you should !!save a method like this and reuse maybe.
    boolean contains(int[][] grid, int r, int c) {
        return r >= 0 && c >= 0 && r < grid.length && c < grid[0].length;
    }
}