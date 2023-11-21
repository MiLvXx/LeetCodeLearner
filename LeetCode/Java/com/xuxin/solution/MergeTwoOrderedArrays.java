package com.xuxin.solution;

import java.util.Arrays;

public class MergeTwoOrderedArrays {
    /**
     * 
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public static void merge(int[] nums1, int m, int[] nums2, int n) {

        if (m == 0) {
            for (int i = 0; i < n; i++) {
                nums1[i] = nums2[i];
            }
        } else {
            int start = 0;
            if (n != 0) {
                for (int i = m; i < m + n; i++) {
                    nums1[i] = nums2[start++];
                }
                Arrays.sort(nums1);
            }
        }

        System.out.println(Arrays.toString(nums1));

    }

}
