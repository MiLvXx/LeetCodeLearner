package com.xuxin.solution;

public class IsInterleave {
    public boolean isInterleave(String s1, String s2, String s3) {
        int height = s1.length(), width = s2.length();
        if (height + width != s3.length()) return false;
        boolean dp[][] = new boolean[height + 1][width + 1];
        for (int i = 0; i <= height; i++) {
            for (int j = 0; j <= width; j++) {
                if (i != 0 && j != 0) {
                    dp[i][j] = (dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1)) ||
                            (dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1));
                } else if (j != 0) { // 上边界
                    dp[i][j] = dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(j - 1);
                } else if (i != 0) { // 左边界
                    dp[i][j] = dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i - 1);
                } else {
                    dp[i][j] = true;
                }
            }
        }
        return dp[height + 1][width + 1];
    }

}
