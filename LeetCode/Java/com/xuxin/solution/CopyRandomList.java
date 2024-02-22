package com.xuxin.solution;

import java.util.HashMap;
import java.util.Map;

public class CopyRandomList {
    /**
     * 
     * @param head
     * @return 复制链表的头节点
     * 1.不考虑[random]指针，类似链表复制，创建新节点，同时使用[哈希表]记录原节点和新节点的映射关系
     * 2.对新旧链表同时遍历，在新链表中构造[random]关系
     */
    public Node copyRandomList(Node head) {
        Node t = head;
        Node copy = new Node(-10010), cur = copy;
        Map<Node, Node> map = new HashMap<>();
        while (head != null) {
            Node node = new Node(head.val);
            map.put(head, node);
            cur.next = node;
            cur = cur.next;
            head = head.next;
        }
        cur = copy.next;
        head = t;
        while (head != null) {
            cur.random = map.get(head.random);
            cur = cur.next;
            head = head.next;
        }
        return copy.next;
    }
}

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }

}