package com.xuxin.solution;

public class IsAnagram {
    public static final int ASCII_NUM = 128;
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] hashS = new int[ASCII_NUM];
        int[] hashT = new int[ASCII_NUM];
        for (int i = 0; i < s.length(); i++) {
            hashS[s.charAt(i)]++;
            hashT[t.charAt(i)]++;
        }
        for (int i = 0; i < ASCII_NUM; i++) {
            if (hashS[i] != hashT[i]) {
                return false;
            }
        }
        return true;
    }
}
