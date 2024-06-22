package com.xuxin.solution;

public class TrailingZeroes {
    public int trailingZeroes(int n) {
        int cnt = 0;
        while (n > 0) {
            cnt += n / 5;
            n = n / 5;
        } 
        return cnt;

    }

}
