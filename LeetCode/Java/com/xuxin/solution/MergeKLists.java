package com.xuxin.solution;

import com.xuxin.util.ListNode;

public class MergeKLists {
    private ListNode merge(ListNode l1, ListNode l2) {
        ListNode res = new ListNode(-1), pRes = res;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                pRes.next = l1;
                pRes = pRes.next;
                l1 = l1.next;
            } else {
                pRes.next = l2;
                pRes = pRes.next;
                l2 = l2.next;
            }
        }
        if (l1 != null) {
            pRes.next = l1;
        } else if (l2 != null) {
            pRes.next = l2;
        }
        return res.next;
    }

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        ListNode l1 = lists[0];
        for (int i = 1; i < lists.length; i++) {
            l1 = merge(l1, lists[i]);
        }
        return l1;
    }
}
