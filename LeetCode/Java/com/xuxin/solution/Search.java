package com.xuxin.solution;

/**
 * Leetcode33.搜索旋转排序数组
 * 评论用户id为`lcl`的分享
 * 
 *  1. 首先明白，旋转数组后，从中间划分，一定有一边是有序的。
 *  2. 由于一定有一边是有序的，所以根据有序的两个边界值来判断目标值在有序一边还是无序一边
 *  3. 这题找目标值，遇到目标值即返回
 *  4. 注意：由于有序的一边的边界值可能等于目标值，所以判断目标值是否在有序的那边时应该加个等号
 */
public class Search {
    public int search(int[] nums, int target) {
        int len = nums.length;
        if (len == 0)
            return -1;

        int left = 0, right = len - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            }

            // right is ordered
            if (nums[mid] < nums[right]) {
                if (target > nums[mid] && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            } else { // left is ordered
                if (target >= nums[left] && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        }
        return -1;
    }
}
