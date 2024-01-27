package com.xuxin.solution;

public class CanConstruct {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] hash = new int[127];
        for (char c : magazine.toCharArray()) {
            hash[c]++;
        }

        for (char c : ransomNote.toCharArray()) {
            if (hash[c]-- < 1) {
                return false;
            }
        }
        return true;
    }
}
