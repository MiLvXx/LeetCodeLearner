package com.xuxin.solution;

import java.util.List;

public class MinimumTotal {
    public int minimumTotal(List<List<Integer>> triangle) {
        int height = triangle.size();
        int[][] dp = new int[height][];
        for (int k = 0; k < height; k++) dp[k] = new int[k+1];

        for (int i = height - 1; i >= 0; i--) {
            List<Integer> row = triangle.get(i);
            for (int j = 0; j < row.size(); j++) {
                if (i == height - 1) dp[i][j] = row.get(j);
                else dp[i][j] = Math.min(dp[i + 1][j], dp[i + 1][j + 1]) + row.get(j);
            }
        }
        return dp[0][0];
    }
}
