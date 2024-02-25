package com.xuxin.solution;

import com.xuxin.util.ListNode;

public class DeleteDuplicates {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode pre = head;
        ListNode next = head.next;
        while (next != null) {
            if (pre.val == next.val) {
                pre.next = next.next;
                next.next = null;
                next = pre.next;
            } else {
                pre = pre.next;
                next = next.next;
            }
        }
        return head;
    }
}
