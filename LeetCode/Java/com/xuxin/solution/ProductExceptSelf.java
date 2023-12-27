package com.xuxin.solution;

import java.util.ArrayList;
import java.util.Arrays;

public class ProductExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] answer = new int[len];
        ArrayList<Integer> zeroIndex = new ArrayList<>();
        int product = 1;
        for (int i = 0; i < len; i++) {
            if (nums[i] == 0) {
                zeroIndex.add(i);
                continue;
            }
            product *= nums[i];

        }
        if (zeroIndex.size() > 1) {
            Arrays.fill(answer, 0);
        } else if (zeroIndex.size() == 1) {
            Arrays.fill(answer, 0);
            answer[zeroIndex.get(0)] = product;
        } else {
            for (int j = 0; j < len; j++) {
                answer[j] = product / nums[j];
            }
        }

        return answer;
    }

}
