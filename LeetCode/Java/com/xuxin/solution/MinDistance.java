package com.xuxin.solution;

public class MinDistance {
    public int minDistance(String word1, String word2) {
        int height = word1.length(), width = word2.length();
        int dp[][] = new int[height + 1][width + 1];

        // init_begin
        dp[0][0] = 0;

        for (int i = 1; i <= width; i++)
            dp[0][i] = i; // upper border

        for (int j = 1; j <= height; j++)
            dp[j][0] = j; // lower border

        // int_end

        for (int i = 1; i <= height; i++) {
            for (int j = 1; j <= width; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1))
                    dp[i][j] = dp[i - 1][j - 1];
                else
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
            }
        }

        return dp[height][width];
    }
}
