package com.xuxin.solution;

/**
 * Leetcode53.最大子数组和
 * - 动态规划
 */
public class MaxSubArray {
    public int maxSubArray(int[] nums) {
        int ans = nums[0];
        int sum = 0;
        for (int num : nums) {
            if (sum > 0) {
                sum += num;
            } else {
                sum = num;
            }
            ans = ans > sum ? ans : sum;
        }
        return ans;
    }
}
