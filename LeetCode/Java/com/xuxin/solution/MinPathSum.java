package com.xuxin.solution;

public class MinPathSum {
    public int minPathSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] dp = new int[m][n];

        for (int left = n - 1, upper = m - 1; left >= 0 && upper >= 0;) {
            for (int i = upper, j = left; i >= 0 && j < n; i--, j++) {
                if (i + 1 < m && j + 1 < n) {
                    dp[i][j] = Math.min(dp[i + 1][j], dp[i][j + 1]) + grid[i][j];
                } else if (i + 1 < m) {
                    dp[i][j] = dp[i + 1][j] + grid[i][j];
                } else if (j + 1 < n) {
                    dp[i][j] = dp[i][j + 1] + grid[i][j];
                } else {
                    dp[i][j] = grid[i][j];
                }
            }
            if (left > 0)
                left--;
            else
                upper--;
        }
        return dp[0][0];
    }

    public static void main(String[] args) {
        new MinPathSum().minPathSum(new int[][] {
                { 1, 3, 1 },
                { 1, 5, 1 },
                { 4, 2, 1 }
        });
    }
}