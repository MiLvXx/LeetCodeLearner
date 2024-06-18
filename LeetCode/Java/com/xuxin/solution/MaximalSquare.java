package com.xuxin.solution;

public class MaximalSquare {
    public int maximalSquare(char[][] matrix) {
        int height = matrix.length, width = matrix[0].length;
        int dp[][] = new int[height][width];
        int len = Integer.MIN_VALUE;
        dp[0][0] = matrix[0][0];

        for (int row = 0; row < height; row++) {
            for (int col = 0; col < width; col++) {
                if (matrix[row][col] == '0')
                    continue;

                if (row == 0 || col == 0) {
                    if (matrix[row][col] == '1')
                        dp[row][col] = 1;
                } else {
                    dp[row][col] = Math.min(dp[row - 1][col - 1],
                            Math.min(dp[row - 1][col], dp[row][col - 1])) + 1;
                }

                if (dp[row][col] > len) {
                    len = dp[row][col];
                }
            }
        }
        return len == Integer.MIN_VALUE ? 0 : len * len;

    }
}
