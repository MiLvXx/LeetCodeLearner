package com.xuxin.solution;

public class Rotate {
    public void rotate(int[] nums, int k) {
        /*
         * 使用额外的数组将元素存放到正确位置
         * 将原下表为i的元素放至新数组下表为 (i+k) mod len
         */
        int len = nums.length;
        int[] newArr = new int[len];
        for (int i = 0; i < len; i++) {
            newArr[(i + k) % len] = nums[i];
        }
        System.arraycopy(newArr, 0, nums, 0, len);
    }
}