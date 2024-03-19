package com.xuxin.solution;

import java.util.ArrayDeque;
import java.util.Deque;

public class DecodeString {
    public String decodeString(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        StringBuilder ans = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c == ']') {
                Character a;
                StringBuilder sb = new StringBuilder(), countBuffer = new StringBuilder();
                StringBuffer charBuffer = new StringBuffer();
                while ((a = stack.removeLast()) != '[') {
                    charBuffer.append(a);
                }
                while (!stack.isEmpty() && Character.isDigit(stack.peekLast())) {
                    countBuffer.append(stack.removeLast());
                }
                int count = Integer.valueOf(countBuffer.reverse().toString());
                String str = charBuffer.reverse().toString();
                for (int i = 0; i < count; i++) {
                    sb.append(str);
                }
                for (Character character : sb.toString().toCharArray()) {
                    stack.add(character);
                }
            } else {
                stack.add(c);
            }
        }
        while (!stack.isEmpty()) {
            ans.append(stack.removeFirst());
        }
        return ans.toString();
    }

    public static void main(String[] args) {
        String s = "100[leetcode]";
        System.out.println(new DecodeString().decodeString(s));
    }
}
