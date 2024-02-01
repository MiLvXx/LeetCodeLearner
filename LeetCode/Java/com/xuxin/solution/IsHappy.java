package com.xuxin.solution;

import java.util.HashSet;
import java.util.Set;

public class IsHappy {
    private int getNext(int n) {
        int nextSum = 0;
        while (n > 0) {
            int d = n % 10;
            nextSum += d * d;
            n /= 10;
        }
        return nextSum;
    }
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        while (n != 1 && !set.contains(n)) {
            set.add(n);
            n = getNext(n);
        }
        
        return n == 1;
    }
}
