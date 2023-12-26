package com.xuxin.solution;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/*
 * 实现类中所有函数
 * 并且满足每个函数的平均时间复杂度为O(1)
 */
public class RandomizedSet {
    static int[] nums = new int[200010];
    Random random = new Random();
    Map<Integer, Integer> map = new HashMap<>();
    int idx = -1;

    public boolean insert(int val) {
        if (map.containsKey(val)) {
            return false;
        }
        nums[++idx] = val;
        map.put(val, idx);
        return true;
    }

    public boolean remove(int val) {
        if (!map.containsKey(val)) {
            return false;
        }
        int loc = map.remove(val);
        if (loc != idx) {
            map.put(nums[idx], loc);
        }
        nums[loc] = nums[idx--];
        return true;
    }

    public int getRandom() {

        return nums[random.nextInt(idx + 1)];
    }

}