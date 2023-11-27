package com.xuxin.solution;

public class RemoveDuplicates2 {
    /**
     * 删除有序数组重复项通解     
     * @param nums
     * @param k 问题中的保留位数
     * @return 新数组长度
     */
    int process(int[] nums, int k) {
        int u = 0;
        for(int x : nums) {
            if (u < k || nums[u - k] != x) {
                nums[u++] = x;
            }
        }

        return u;
    }

    public int removeDuplicates(int[] nums) {
        return process(nums, 2);
    }
}
