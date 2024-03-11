package com.xuxin.solution;

/**
 * 正难则反
 * Leetcode1658.将x减到0的最小操作数
 * -> 问题转化为：
 * [从nums中移除一个最长的子数组，使得剩余元素的和为x]
 */
public class MinOperations {
    public int minOperations(int[] nums, int x) {
        int target = -x;
        for (int num : nums) {
            target += num;
        }
        if (target < 0) {
            return -1;
        }
        int ans = -1, left = 0, sum = 0, n = nums.length;
        for (int right = 0; right < n; right++) {
            sum += nums[right];
            while (sum > target) {
                sum -= nums[left++];
            }
            if (sum == target) {
                ans = Math.max(ans, right - left + 1);
            }
        }
        return ans < 0 ? -1 : n - ans;
    }

    public static void main(String[] args) {
        int[] nums = new int[] { 1, 1, 4, 2, 3 };
        new MinOperations().minOperations(nums, 5);
    }
}
