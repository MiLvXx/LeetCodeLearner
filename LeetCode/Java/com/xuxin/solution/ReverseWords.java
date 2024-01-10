package com.xuxin.solution;

public class ReverseWords {
    public String reverseWords(String s) {
        s = s.trim();

        int len = s.length();
        StringBuilder builder = new StringBuilder();
        boolean isChar = true;
        int lastIndex = len;
        for (int i = len - 1; i >= 0; i--) {
            Character cur = s.charAt(i);
            if (cur.equals(' ')) {
                if (isChar) {
                    isChar = false;
                    String word = s.substring(i+1, lastIndex);
                    builder.append(word + " ");
                }
            } else {
                if (!isChar) {
                    lastIndex = i+1;
                }
                isChar = true;
            }
        }
        builder.append(s.substring(0, lastIndex));

        return builder.toString();
    }
}
