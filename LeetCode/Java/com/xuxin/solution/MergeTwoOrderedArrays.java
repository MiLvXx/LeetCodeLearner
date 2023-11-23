package com.xuxin.solution;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class MergeTwoOrderedArrays {
    /**
     * 
     * @param nums1 非递减数列
     * @param m nums1 元素数目
     * @param nums2 非递减数列
     * @param n nums2 元素数目
     */
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        
        /*solution1: 合并排序 */
        // if (m == 0) {
        //     for (int i = 0; i < n; i++) {
        //         nums1[i] = nums2[i];
        //     }
        // } else {
        //     int start = 0;
        //     if (n != 0) {
        //         for (int i = m; i < m + n; i++) {
        //             nums1[i] = nums2[start++];
        //         }
        //         Arrays.sort(nums1);
        //     }
        // }

        /*solution2: 双指针 */

        int flag1 = 0;
        int flag2 = 0;
        Queue<Integer> tmpQueue = new LinkedList<>();
        while (flag1 < m && flag2 < n) {
            int num1 = nums1[flag1];
            int num2 = nums2[flag2];
            if (num2 > num1) {
                flag1++;
                tmpQueue.add(num1);
            } else {
                flag2++;
                tmpQueue.add(num2);
            }
        }
        if(flag1 == m){
            for (int i = flag2; i < n; i++) {
                tmpQueue.add(nums2[i]);
            }
        }else if (flag2 == n) {
            for (int j = flag1; j < m; j++) {
                tmpQueue.add(nums1[j]);
            }
        }

        for (int k = 0; k < m+n; k++) {
            nums1[k] = (Integer)tmpQueue.remove();
        }

        System.out.println(Arrays.toString(nums1));

    }

}
