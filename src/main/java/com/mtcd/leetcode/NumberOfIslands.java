package com.mtcd.leetcode;

public class NumberOfIslands {

    public static int numberOfIslands(int[][] grid) {
        int height = grid.length;
        int length = grid[0].length;
        if (height < 1 || length < 1)
            return 0;

        int islands = 0;
        boolean[][] searched = new boolean[grid.length][grid[0].length];

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < length; j++) {
                if (searched[i][j])
                    continue;
                if (grid[i][j] == 0) {
                    searched[i][j] = true;
                    continue;
                }
                islands++;
                dfs(grid, i, j, searched);
            }
        }
        return islands;
    }

    private static void dfs(int[][] grid, int row, int col,
                            boolean[][] searched) {
        searched[row][col] = true;
        if (grid[row][col] == 0)
            return;

        int[][] directions = new int[][]{{0, -1}, {-1, 0}, {0, 1}, {1, 0}};
        for (int[] dir : directions) {
            int newRow = row + dir[0];
            int newCol = col + dir[1];
            if (newRow >= grid.length || newRow < 0)
                continue;
            if (newCol >= grid[0].length || newCol < 0)
                continue;
            if (searched[newRow][newCol])
                continue;
            dfs(grid, newRow, newCol, searched);
        }
    }

    public static void main(String[] args) {
        int[][] grid = new int[][]{
                {1, 0, 0, 0, 0},
                {0, 1, 1, 0, 0},
                {0, 1, 1, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 1, 1, 0, 1}};
        System.out.println(numberOfIslands(grid));
    }
}
