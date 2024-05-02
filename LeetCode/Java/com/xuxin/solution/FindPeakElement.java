package com.xuxin.solution;

/**
 * Leetcode162.寻找峰值
 */
public class FindPeakElement {
    public int findPeakElement(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (mid != nums.length-1 && nums[mid] < nums[mid + 1]) {
                left = mid + 1;
            } else if (mid != 0 && nums[mid] < nums[mid - 1]) {
                right = mid - 1;
            } else {
                return mid;
            }
        } 
        return -1;
    }
}