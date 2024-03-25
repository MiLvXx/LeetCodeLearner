package com.xuxin.solution;
/**
 * 数组中全部元素的异或运算结果即为数组中只出现一次的数字
 * 异或运算满足交换律和结合律, 
 *  a ^ b ^ a 
 *  = a ^ a ^ b     
 *  = 0 ^ b = b
 */
public class SingleNumber {
    public int singleNumber(int[] nums) {
        int single = 0;
        for (int i : nums) {
            single ^= i;
        }
        return single;
    }
}
