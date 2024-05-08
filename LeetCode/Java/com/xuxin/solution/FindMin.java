package com.xuxin.solution;

public class FindMin {
    public int findMin(int[] nums) {
        int lo = 0, hi = nums.length - 1;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] >= nums[0]) {
                lo = mid;
            } else {
                hi = mid-1;
            }
        }
        return hi + 1 < nums.length ? nums[hi+1] : nums[0];
    }
}
