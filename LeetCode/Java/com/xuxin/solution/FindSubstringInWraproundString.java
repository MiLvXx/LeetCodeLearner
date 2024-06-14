package com.xuxin.solution;

import java.util.Arrays;

public class FindSubstringInWraproundString {
    public int findSubstringInWraproundString(String s) {
        int len = s.length();
        int[] dp = new int[len];
        int[] hash = new int[127];

        dp[0] = hash[s.charAt(0)] = 1;
        for (int i = 1; i < len; i++) {
            boolean isRepeat = false;
            if (hash[s.charAt(i)] != 0) {
                isRepeat = true;
            }
            if ((s.charAt(i) - s.charAt(i - 1)) == 1 ||
                    s.charAt(i) - s.charAt(i - 1) == -25) {
                if (isRepeat) {
                    hash[s.charAt(i)] = Math.max(dp[i - 1] + 1, hash[s.charAt(i)]);
                } else {
                    hash[s.charAt(i)] = dp[i-1]+1;
                }
                dp[i] = dp[i - 1] + 1;
            } else {
                if (!isRepeat) {
                    hash[s.charAt(i)] = 1;
                }
                dp[i] = 1;
            }
        }
        return Arrays.stream(hash).sum();
    }

    public static void main(String[] args) {
        new FindSubstringInWraproundString().findSubstringInWraproundString("aabb");
    }
}
