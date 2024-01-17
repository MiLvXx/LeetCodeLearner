package com.xuxin.solution;

public class MinSubArrayLen {
    public int minSubArrayLen(int target, int[] nums) {
        int len = nums.length;
        if (len == 0) return 0;

        int res = Integer.MAX_VALUE;
        int head = 0, tail = 0;
        int sum = 0;
        while (tail < len) {
            sum += nums[tail];
            while (sum >= target) {
                res = Math.min(res, tail - head + 1);
                sum -= nums[head];
                head++;
            }
            tail++;
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }
}
