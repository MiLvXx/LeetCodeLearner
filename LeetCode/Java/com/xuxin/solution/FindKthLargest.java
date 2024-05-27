package com.xuxin.solution;

/**
 * @Description: 基于快排的选择方法
 *               时间复杂度: O(n)
 *               空间复杂度: O(log n)
 */
public class FindKthLargest {
    public int findKthLargest(int[] nums, int k) {
        int n = nums.length;
        return quickSelect(nums, 0, n - 1, n - k); // n-k即为 target_index
    }

    private int quickSelect(int[] nums, int l, int r, int k) {
        if (l == r)
            return nums[k];

        int pivot = nums[l], i = l - 1, j = r + 1;
        while (i < j) {
            do
                i++;
            while (nums[i] < pivot);

            do
                j--;
            while (nums[j] > pivot);

            if (i < j)
                swap(nums, j, i);
        }

        if (k <= j)
            return quickSelect(nums, l, j, k);
        else
            return quickSelect(nums, j + 1, r, k);

    }

    private void swap(int[] nums, int lo, int hi) {
        int temp = nums[lo];
        nums[lo] = nums[hi];
        nums[hi] = temp;
    }

}
