package com.xuxin.solution;

import com.xuxin.util.ListNode;

public class Partition {
    public ListNode partition(ListNode head, int x) {
        ListNode minNode = new ListNode(-101), maxNode = new ListNode(101), 
        pMinNode = minNode, pMaxNode = maxNode;
        while (head != null) {
            if (head.val < x) {
                minNode.next = head;
                minNode = minNode.next;
            } else {
                maxNode.next = head;
                maxNode = maxNode.next;
            }
            head = head.next;
        }
        maxNode.next = null;
        minNode.next = pMaxNode.next;
        return pMinNode.next;
    }
}
