package com.xuxin.solution;

import com.xuxin.util.ListNode;

public class GetIntersectionNode {
    /*
     * 暴力解法
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB){
        ListNode p1 = headA, p2 = headB;
        while (p1 != null) {
            while (p2 != null) {
                if (p2 == p1) {
                    return p2;
                }
                p2 = p2.next;   
            }
            p1 = p1.next;
            p2 = headB;
        }
        return null;
    }
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(8);
        ListNode node3 = new ListNode(4);
        ListNode node4 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        ListNode listA = new ListNode(4);
        listA.next = node1;
        ListNode listB = new ListNode(5);
        ListNode node7 = new ListNode(6);
        listB.next = node7;
        node7.next = node1;

        new GetIntersectionNode().getIntersectionNode(listA, listB);
    }
}
