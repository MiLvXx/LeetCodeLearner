package com.xuxin.solution;

import com.xuxin.util.ListNode;

public class RotateRight {

    public ListNode rotateRight(ListNode head, int k) {
        int len = 0, count = 1;
        ListNode phead = head, copyHead = head, tail = null, newHead = null;
        while (phead != null) {
            len++;
            if (phead.next == null) {
                tail = phead;
            }
            phead = phead.next;
        }
        if (k % len == 0 || len == 0) {
            return copyHead;
        }
        while (head != null) {
            if (count == len - k % len) {
                newHead = head.next;
                head.next = null;
                tail.next = copyHead;
                break;
            }
            head = head.next;
            count++;
        }
        return newHead;
    }
}