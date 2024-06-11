package com.xuxin.solution;

import java.util.Arrays;

public class LengthOfLIS {
    public int lengthOfLIS(int[] nums) {
        int len = nums.length;
        int res = Integer.MIN_VALUE;
        int[] dp = new int[len];
        Arrays.fill(dp, 1);
        for (int i = len - 1; i >= 0; i--) {
            int maxPath = 0;
            for (int j = i + 1; j < len; j++) {
                if (nums[j] > nums[i]) {
                    if (dp[j] + 1 > maxPath) {
                        maxPath = dp[j] + 1;
                    }
                }
            }
            dp[i] = maxPath == 0 ? 1 : maxPath;
            if (dp[i] > res)
                res = dp[i];
        }
        return res;
    }
}
