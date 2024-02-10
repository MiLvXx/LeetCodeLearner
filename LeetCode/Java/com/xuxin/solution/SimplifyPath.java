package com.xuxin.solution;

import java.util.Stack;

public class SimplifyPath {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        for (String string : path.split("/")) {
            if (string.equals("") || string.equals(".")) {
                continue;
            }
            if (string.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                stack.push(string);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (String string : stack) {
            sb.append("/");
            sb.append(string);
        }
        return sb.length() == 0 ? "/" : sb.toString();
    }
}
