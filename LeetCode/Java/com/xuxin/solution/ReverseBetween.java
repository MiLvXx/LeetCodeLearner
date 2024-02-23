package com.xuxin.solution;

import java.util.Stack;

import com.xuxin.util.ListNode;

public class ReverseBetween {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        int count = 1;
        Stack<ListNode> stack = new Stack<>();
        ListNode middleNode = new ListNode(-510), leftNode = null, rightNode = null, res = head;
        while (head != null) {
            if (count == left - 1) {
                leftNode = head;
            } else if (count >= left && count <= right) {
                stack.push(head);
            } else if (count == right + 1) {
                rightNode = head;
            }
            head = head.next;
            count++;
        }
        ListNode pMiddleNode = middleNode;
        while (stack.size() != 0) {
            pMiddleNode.next = stack.pop();
            pMiddleNode = pMiddleNode.next;
        }
        pMiddleNode.next = rightNode;
        if (leftNode == null)
            return middleNode.next;

        leftNode.next = middleNode.next;
        return res;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        new ReverseBetween().reverseBetween(head, 2, 4);
    }
}
