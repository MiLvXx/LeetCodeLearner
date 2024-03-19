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
                StringBuilder sb = new StringBuilder(),
                        cntB = new StringBuilder(),
                        charB = new StringBuilder();
                while ((a = stack.removeLast()) != '[') {
                    charB.append(a);
                }
                while (!stack.isEmpty() && Character.isDigit(stack.peekLast())) {
                    cntB.append(stack.removeLast());
                }
                int count = Integer.valueOf(cntB.reverse().toString());
                String str = charB.reverse().toString();
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
}
