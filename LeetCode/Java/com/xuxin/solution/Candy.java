package com.xuxin.solution;

import java.util.Arrays;

public class Candy {
    public int candy(int[] ratings) {
        int len = ratings.length;
        int[] L_R = new int[len];
        int[] R_L = new int[len];

        Arrays.fill(L_R, 1);
        Arrays.fill(R_L, 1);
        for (int i = 0; i < len-1; i++) {
            if (ratings[i+1] > ratings[i]) {
                L_R[i+1] = L_R[i]+1;
            }
        }
        for (int j = len-1; j > 0; j--) {
            if (ratings[j-1] > ratings[j]) {
                R_L[j-1] = R_L[j]+1;
            }
        }
        int sum = 0;
        for (int k = 0; k < len; k++) {
            sum += (L_R[k] > R_L[k] ? L_R[k] : R_L[k]);
        }
        return sum;
    }
}
