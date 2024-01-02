package com.xuxin.solution;

public class LengthOfLastWord {
    public int lengthOfLastWord(String s) {
        int length = 0;
        s = s.trim();
        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            if (c == ' ') {
                return length;
            }
            length++;
        }
        return length;
    }
}
