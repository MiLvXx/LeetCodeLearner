package com.xuxin.solution;

import com.xuxin.util.ListNode;

public class DeleteDuplicates2 {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode next = head.next, post = new ListNode(-101), pre = post;
        post.next = head;
        while (next != null) {
            if (head.val == next.val) {
                post.val = head.val;
                head.next = next.next;
                next.next = null;
                next = head.next;
            } else {
                if (head.val == post.val) {
                    pre.next = next;
                    head.next = null;
                    head = pre.next;
                    next = head.next;
                } else {
                    head = head.next;
                    next = next.next;
                    pre = pre.next;
                }
            }
        }
        if (head.val == post.val) {
            pre.next = next;
        }
        return post.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(1);
        // head.next.next = new ListNode(1);
        // head.next.next.next = new ListNode(3);
        // head.next.next.next.next = new ListNode(4);
        // head.next.next.next.next.next = new ListNode(4);
        // head.next.next.next.next.next.next = new ListNode(5);

        new DeleteDuplicates2().deleteDuplicates(head);
    }
}
