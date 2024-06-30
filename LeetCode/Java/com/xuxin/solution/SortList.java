package com.xuxin.solution;

import com.xuxin.util.ListNode;

public class SortList {
    public ListNode sortList(ListNode head) {
        return mergeSort(head);
    }

    /**
     * 找到链表中点
     * 
     * @param head the head node
     * @return
     */
    public ListNode findMid(ListNode head) {
        if (head == null)
            return head;

        ListNode fast = head.next, slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow;
    }

    /**
     * 拆分过程
     * 
     * @param head the head node
     * @return
     */
    public ListNode mergeSort(ListNode head) {
        // 当head.next==null时，说明当前链表只有一个元素
        if (head == null || head.next == null)
            return head;
        ListNode mid = findMid(head);

        ListNode next = mid.next;

        mid.next = null; // 从中间结点断开，分别对两边mergeSort

        ListNode left = mergeSort(head);
        ListNode right = mergeSort(next);

        return merge(left, right);
    }

    /**
     * 合并过程
     * 
     * @param l1 the first node
     * @param l2 the second node
     * @return
     */
    public ListNode merge(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }

        if (l1 != null)
            cur.next = l1;
        if (l2 != null)
            cur.next = l2;

        return dummy.next;
    }

}
