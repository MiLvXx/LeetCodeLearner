package com.xuxin.solution;

import java.util.ArrayDeque;
import java.util.Deque;

import com.xuxin.util.ListNode;

public class ListIsPalindrome {
    public boolean isPalindrome(ListNode head) {
        Deque<Integer> deque = new ArrayDeque<>();
        while (head != null) {
            deque.add(head.val);
            head = head.next;
        }
        while (!deque.isEmpty()) {
            if (deque.size() == 1) {
                return true;
            }
            if(deque.removeFirst() != deque.removeLast()){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(0);
        ListNode node3 = new ListNode(1);
        // ListNode node4 = new ListNode(1);
        node1.next = node2;
        node2.next = node3;
        // node3.next = node4;
        new ListIsPalindrome().isPalindrome(node1);
    }
}
