package com.xuxin.solution;

import java.util.Stack;

public class IsValid {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (Character c : s.toCharArray()) {
            if (c.equals('(') || c.equals('[') || c.equals('{')) {
                stack.push(c);
            } else {
                switch (c) {
                    case ')':
                        if (stack.isEmpty() || !stack.pop().equals('('))
                            return false;
                        break;
                    case ']':
                        if (stack.isEmpty() || !stack.pop().equals('['))
                            return false;
                        break;
                    case '}':
                        if (stack.isEmpty() || !stack.pop().equals('{'))
                            return false;
                        break;
                }
            }

        }
        return stack.isEmpty() ? true : false;
    }

    public static void main(String[] args) {
        boolean b = new IsValid().isValid("]{}");
        System.out.println(b);
    }
}