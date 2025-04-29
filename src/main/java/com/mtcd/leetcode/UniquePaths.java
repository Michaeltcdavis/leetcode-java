package com.mtcd.leetcode;

public class UniquePaths {

    /**
     * Function to calculate the number of unique paths a robot could take to
     * traverse from 0,0 to m - 1, n - 1 in an m x n grid. The robot can only
     * move down or left.
     *
     * @param m the length in steps of one dimension of the grid
     * @param n the length in steps of the other dimension of the grid
     * @return the number of unique paths the robot could take
     */
    public static int uniquePaths(int m, int n) {
        int[][] memo = new int[m][n];
        for (int i = 1; i < n; i++) {
            memo[0][i] = 1;
        }
        for (int i = 1; i < m; i++) {
            memo[i][0] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                memo[i][j] = memo[i - 1][j] + memo[i][j - 1];
            }
        }
        return memo[m - 1][n - 1];
    }

    public static void main(String[] args) {
        System.out.println(uniquePaths(3, 7));
    }
}
