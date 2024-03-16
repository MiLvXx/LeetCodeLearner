package com.xuxin.solution;

import java.util.ArrayDeque;
import java.util.Deque;

import com.xuxin.util.ListNode;

public class SwapPairs {
    public ListNode swapPairs(ListNode head) {
        Deque<ListNode> deque = new ArrayDeque<>();
        ListNode res = new ListNode(-1), pRes = res;
        while (head != null) {
            deque.add(head);
            head = head.next;
            if (deque.size() == 2) {
                while (!deque.isEmpty()) {
                    pRes.next = deque.removeLast();
                    pRes = pRes.next;
                }
            }
        }
        if (!deque.isEmpty()) {
            pRes.next = deque.removeLast();
            pRes = pRes.next;
            
        }
        pRes.next = null;
        return res.next;
    }
}
