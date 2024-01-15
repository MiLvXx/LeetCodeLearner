package com.xuxin.solution;

public class IsPalindrome {
    private String process(String s) {
        StringBuilder newStr = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (Character.isLetter(c) || Character.isDigit(c)) {
                if (Character.isUpperCase(c)) {
                    newStr.append(Character.toLowerCase(c));
                } else {
                    newStr.append(c);
                }

            }
        }
        return newStr.toString();
    }

    public boolean isPalindrome(String s) {
        String str = process(s);

        for (int i = 0, j = str.length() - 1; i < str.length() / 2; i++, j--) {
            if (str.charAt(i) != str.charAt(j)) {
                return false;
            }
        }
        return true;
    }
    
}