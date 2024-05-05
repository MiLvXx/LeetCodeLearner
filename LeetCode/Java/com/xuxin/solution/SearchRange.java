package com.xuxin.solution;

public class SearchRange {

    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[] { -1, -1 };

        int len = nums.length;

        int left = 0, right = len - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                res[0] = mid;
                right = mid - 1; // attention
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        int lo = 0, hi = len - 1;
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            if (nums[mid] == target) {
                res[1] = mid;
                lo = mid + 1; // attention
            } else if (nums[mid] > target) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        new SearchRange().searchRange(new int[] { 5, 7, 7, 8, 8, 10 }, 8);
    }
}
