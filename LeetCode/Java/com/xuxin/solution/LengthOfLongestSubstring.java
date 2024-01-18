package com.xuxin.solution;

public class LengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        int i = 0, j = 0;
        int res = Integer.MIN_VALUE;
        int len = s.length();
        int[] hash = new int[128];
        while (j < len) {
            char cur = s.charAt(j);
            hash[cur]++;
            while (hash[cur] > 1) {
                res = j - i > res ? j - i : res;
                hash[s.charAt(i++)]--;
            }
            j++;
        }
        return j - i > res ? j - i : res;
    }
}
