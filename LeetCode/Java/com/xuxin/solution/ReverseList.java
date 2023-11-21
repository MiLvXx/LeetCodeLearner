package com.xuxin.solution;
import com.xuxin.util.ListNode;

/**
 * 206.反转链表
 */

public class ReverseList {
    /**
     * 迭代
     * @param res
     * @return
     */
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode res = new ListNode(head.val);
        ListNode tmp = new ListNode(head.val);
        
        while (head.next != null) {
            head = head.next;
            res = new ListNode(head.val);
            res.next = tmp;
            tmp = res;
        }
        return res;
    }
    

    /**
     * 递归解法
     * @param head
     * @return
     */
    public ListNode reverseList1(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        
        ListNode newHead = reverseList(head.next);
        head.next.next = head;
        head.next = null;

        return newHead;
    }

    
}

