package com.xuxin.solution;

import java.util.Stack;

public class EvalRPN {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String str : tokens) {
            if (str.matches("-?\\d+(\\.\\\\d+)?")) {
                stack.push(Integer.valueOf(str));
            } else if (stack.size() > 1) {
                Integer n1 = stack.pop();
                Integer n2 = stack.pop();
                switch (str) {
                    case "+":
                        stack.push(n2 + n1);
                        break;
                    case "-":
                        stack.push(n2 - n1);
                        break;
                    case "*":
                        stack.push(n2 * n1);
                        break;
                    case "/":
                        stack.push(n2 / n1);
                        break;
                }
            }
        }
        return stack.firstElement();
    }

    public static void main(String[] args) {
        new EvalRPN().evalRPN(new String[] { "10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+" });
    }
}
