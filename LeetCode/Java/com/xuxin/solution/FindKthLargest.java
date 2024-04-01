package com.xuxin.solution;

/**
 * @Description: 基于快排的选择方法
 *               时间复杂度: O(n)
 *               空间复杂度: O(log n)
 */
public class FindKthLargest {
    private int quickSelect(int[] nums, int l, int r, int k) {
        if (l == r) {
            return nums[k];
        }
        int x = nums[l], i = l - 1, j = r + 1;
        while (i < j) {
            do
                i++;
            while (nums[i] < x);

            do
                j--;
            while (nums[j] > x);

            if (i < j) {
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
            }
        }
        if (k <= j) {
            return quickSelect(nums, l, j, k);
        } else {
            return quickSelect(nums, j + 1, r, k);
        }
    }

    public int findKthLargest(int[] nums, int k) {
        int n = nums.length;
        return quickSelect(nums, 0, n - 1, n - k); // n-k即为target
    }

    public static void main(String[] args) {
        var nums = new int[] { 1, 5, 4, 3, 2 };
        var ans = new FindKthLargest().findKthLargest(nums, 3);
        System.out.println(ans);
    }
}
