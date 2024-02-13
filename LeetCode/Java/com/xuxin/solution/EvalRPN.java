package com.xuxin.solution;

import java.util.Stack;

public class EvalRPN {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        Integer n1, n2;
        for (String str : tokens) {
            switch (str) {
                case "+":
                    n1 = stack.pop();
                    n2 = stack.pop();
                    stack.push(n2 + n1);
                    break;
                case "-":
                    n1 = stack.pop();
                    n2 = stack.pop();
                    stack.push(n2 - n1);
                    break;
                case "*":
                    n1 = stack.pop();
                    n2 = stack.pop();
                    stack.push(n2 * n1);
                    break;
                case "/":
                    n1 = stack.pop();
                    n2 = stack.pop();
                    stack.push(n2 / n1);
                    break;
                default:
                    stack.push(Integer.parseInt(str));
                    break;
            }
        }
        return stack.firstElement();
    }
}
