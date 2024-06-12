package com.xuxin.solution;

public class UniquePathsWithObstacles {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int height = obstacleGrid.length;
        int width = obstacleGrid[0].length;
        int[][] dp = new int[height][width];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (obstacleGrid[i][j] == 1)
                    continue;
                if (i > 0 && j > 0) {
                    if (obstacleGrid[i - 1][j] == 0 && obstacleGrid[i][j - 1] == 0) {
                        dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                    } else if (obstacleGrid[i - 1][j] == 0) {
                        dp[i][j] = dp[i - 1][j];
                    } else {
                        dp[i][j] = dp[i][j - 1];
                    }
                } else if (i > 0) {
                    if (obstacleGrid[i - 1][j] == 0) {
                        dp[i][j] = dp[i - 1][j];
                    }
                } else if (j > 0) {
                    if (obstacleGrid[i][j - 1] == 0) {
                        dp[i][j] = dp[i][j - 1];
                    }
                } else {
                    dp[i][j] = 1;
                }
            }
        }
        return dp[height - 1][width - 1];
    }
}
