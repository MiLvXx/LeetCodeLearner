package com.xuxin.solution;

import java.util.Deque;
import java.util.LinkedList;

public class MaxSlidingWindow {

    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length < 2) {
            return nums;
        }

        Deque<Integer> queue = new LinkedList<>();
        int[] res = new int[nums.length - k + 1];
        for (int i = 0; i < nums.length; i++) {
            
            // 保证从大到小，如果前面数字较小则依次弹出
            while (!queue.isEmpty() && nums[queue.peekLast()] <= nums[i]) {
                queue.pollLast();
            }

            queue.addLast(i);
            // 判断队首的值是否有效
            if (queue.peek() <= i - k) {
                queue.poll();
            }

            // 当窗口长度为k时，保存当前窗口中最大值
            if (i + 1 >= k) {
                res[i + 1 - k] = nums[queue.peek()];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[] { 1, 3, -1, -3, 5, 3, 6, 7 };
        new MaxSlidingWindow().maxSlidingWindow(nums, 3);
    }
}