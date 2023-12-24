package com.xuxin.solution;

public class Jump {
    public int jump(int[] nums) {
        int ans = 0;
        int end = 0;
        int maxPos = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            maxPos = Math.max(nums[i] + i, maxPos);
            if (i == end) {
                end = maxPos;
                ans++;
            }
        }
        return ans;
    }

}
