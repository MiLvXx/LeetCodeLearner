package com.xuxin.solution;

import java.util.Stack;

import com.xuxin.util.ListNode;

public class ReverseKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {        
        Stack<ListNode> stack = new Stack<>();
        ListNode res = new ListNode(-1), pRes = res;
        while (head != null) {
            stack.push(head);
            head = head.next;
            if (stack.size() == k) {
                while (stack.size() != 0) {
                    pRes.next = stack.pop();
                    pRes = pRes.next;
                }
            }   
        }
        if (!stack.isEmpty()) {     
            pRes.next = stack.firstElement();
        } else {
            pRes.next = null;
        }
        return res.next;
    }
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        // head.next.next = new ListNode(3);
        // head.next.next.next = new ListNode(4);
        // head.next.next.next.next = new ListNode(5);
        new ReverseKGroup().reverseKGroup(head, 2);
    }
}
