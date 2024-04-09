package com.xuxin.solution;

public class SplitArray {
    public int splitArray(int[] nums, int k) {
        int max = 0, sum = 0;

        // 计算 [子数组各自的和的最大值] 的上下界
        for (int num : nums) {
            max = Math.max(max, num);
            sum += num;
        }

        int left = max, right = sum;
        while (left < right) {
            int mid = left + (right - left) / 2;
            int splits = split(nums, mid);
            if (splits > k) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }

    /**
     * 
     * @param nums 原数组
     * @param mid  子数组各自的和的最大值
     * @return 满足不超过 [子数组各自的和的最大值] 的分割数
     */
    private int split(int[] nums, int mid) {
        int splits = 1;
        int curIntervalSum = 0;
        for (int num : nums) {
            if (curIntervalSum + num > mid) {
                curIntervalSum = 0;
                splits++;
            }
            curIntervalSum += num;
        }
        return splits;
    }
}
