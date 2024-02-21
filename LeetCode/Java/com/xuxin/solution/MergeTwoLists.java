package com.xuxin.solution;

import com.xuxin.util.ListNode;

public class MergeTwoLists {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head1 = list1, head2 = list2;
        ListNode res = null, node = null;
        int min;
        while (head1 != null && head2 != null) {
            if (head1.val < head2.val) {
                min = head1.val;
                head1 = head1.next;
            } else {
                min = head2.val;
                head2 = head2.next;
            }
            if (res == null) {
                res = node = new ListNode(min);
            } else {
                node.next = new ListNode(min);
                node = node.next;
            }
        }
        while (head1 != null) {
            if (res == null) {
                res = node = new ListNode(head1.val);
            } else {
                node.next = new ListNode(head1.val);
                node = node.next;
            }
            head1 = head1.next;
        }
        while (head2 != null) {
            if (res == null) {
                res = node = new ListNode(head2.val);
            } else {
                node.next = new ListNode(head2.val);
                node = node.next;
            }
            head2 = head2.next;
        }
        return res;
    }

    public static void main(String[] args) {
        ListNode l1 = null;
        // ListNode l1 = new ListNode(1);
        // l1.next = new ListNode(2);
        // l1.next.next = new ListNode(4);
        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);
        new MergeTwoLists().mergeTwoLists(l1, l2);
    }
}
