package com.xuxin.solution;

public class FindDuplicate {
    /* solution1：binary search */
    
    // public int findDuplicate(int[] nums) {
    //     int len = nums.length;
    //     int left = 1, right = len - 1;
    //     while (left < right) {
    //         int mid = (left + right) / 2;
    //         // nums中不大于mid的元素个数
    //         int cnt = 0;
    //         for (int i : nums) {
    //             if (i <= mid) {
    //                 cnt++;
    //             }
    //         }
    //         if (cnt > mid) {
    //             right = mid;
    //         } else {
    //             left = mid + 1;
    //         }
    //     }
    //     return left;
    // }

    /* solution2: 环形链表 */
    public int findDuplicate(int[] nums) {
        int slow = nums[0], fast = nums[nums[0]];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }
        int pre = 0, next = slow;
        while (pre != next) {
            pre = nums[pre];
            next = nums[next];
        }
        return pre;
    }
}
