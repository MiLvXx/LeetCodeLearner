package com.xuxin.solution;

public class LongestPalindrome {
    public String longestPalindrome(String s) {
        int len = s.length();
        int[][] dp = new int[len][len];
        for (int i = 0; i < len; i++) {
            dp[i][i] = 1;
        }
        int lo = 0, hi = 0;
        for (int j = 1; j < len; j++) {
            for (int i = 0; i < j; i++) {
                if (s.charAt(i) != s.charAt(j)) continue;
                if (j - i == 1 || dp[i + 1][j - 1] == 1) {
                    dp[i][j] = 1;
                    if (j - i > hi - lo) {
                        lo = i;
                        hi = j;
                    }
                }
            }
        }
        return s.substring(lo, hi + 1);
    }
}
