package com.xuxin.solution;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

public class NthUglyNumber {
    int[] nums = new int[] { 2, 3, 5 };

    public static void main(String[] args) {
        int num = new NthUglyNumber().nthUglyNumber(10);
        System.out.println(num);
    }

    public int nthUglyNumber(int n) {
        // return solution1(n);
        return solution2(n);
    }

    /**
     * solution 1: 优先队列
     * @param n
     * @return
     */
    public int solution1(int n) {
        Set<Long> set = new HashSet<>(); // 防止同一丑数多次入队
        Queue<Long> pq = new PriorityQueue<>();
        set.add(1L);
        pq.add(1L);
        for (int i = 1; i <= n; i++) {
            long x = pq.poll();
            if (i == n)
                return (int) x;
            for (int num : nums) {
                long t = num * x;
                if (!set.contains(t)) {
                    set.add(t);
                    pq.add(t);
                }
            }
        }
        return -1;
    }

    /**
     * 多路归并
     * @param n
     * @return
     */
    public int solution2(int n) {
        int[] ans = new int[n + 1];
        ans[1] = 1;

        for(int i2 = 1, i3 = 1, i5 = 1, idx = 2; idx <= n; idx++) {
            int a = ans[i2] * 2, b = ans[i3] * 3, c = ans[i5] * 5;

            int min = Math.min(a, Math.min(b, c));

            if (min == a) i2++;
            if (min == b) i3++;
            if (min == c) i5++;
            ans[idx] = min;
        }
        return ans[n];
    }
}
