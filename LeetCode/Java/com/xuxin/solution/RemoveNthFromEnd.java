package com.xuxin.solution;

import com.xuxin.util.ListNode;

public class RemoveNthFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode pHead1 = head, pHead2 = head;
        int size = 0;
        while (pHead1 != null) {
            size++;
            pHead1 = pHead1.next;
        }
        ListNode pre = null, cur = null;
        for (int i = 0; i < size; i++) {
            if (i == size - n - 1) {
                pre = pHead2;
            }
            if (i == size - n) {
                cur = pHead2;
            }
            pHead2 = pHead2.next;
        }
        if (pre == null) {
            return head.next;
        }
        pre.next = cur.next;
        cur.next = null;
        return head;
    }
}