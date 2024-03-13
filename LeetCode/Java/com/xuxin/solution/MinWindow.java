package com.xuxin.solution;

public class MinWindow {
    public String minWindow(String s, String t) {
        int[] hashTable = new int[128];
        for (char c : t.toCharArray()) {
            hashTable[c]++;
        }
        String res = "";
        int cnt = t.length(), head = 0, tail = 0, len = Integer.MAX_VALUE;
        while (tail < s.length()) {
            if (--hashTable[s.charAt(tail)] >= 0) {
                if (--cnt == 0) {
                    while (hashTable[s.charAt(head++)]++ != 0) {
                        hashTable[s.charAt(head)]++;
                        head++;
                    }
                    res = tail - head + 1 < len ? s.substring(head, tail + 1) : res;
                    len = Math.min(tail - head + 1, len);
                    hashTable[s.charAt(head++)]++;
                    cnt++;
                }
            }
            tail++;
        }
        return res;
    }
}