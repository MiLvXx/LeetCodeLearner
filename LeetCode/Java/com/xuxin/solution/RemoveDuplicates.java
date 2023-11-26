package com.xuxin.solution;

import java.util.ArrayList;
import java.util.List;

public class RemoveDuplicates {
    public int removeDuplicates(int[] nums){
        List<Integer> flags = new ArrayList<>();
        
        for (Integer num : nums) {
            if (!flags.contains(num)) {
                flags.add(num);
            }
        }
        int size = flags.size();
        for (int i = 0; i < size; i++) {
            nums[i] = flags.get(i);
        }

        return size;
    }
}
