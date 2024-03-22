package com.xuxin.solution;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    class DLinkedNode {
        int key;
        int value;
        DLinkedNode prev;
        DLinkedNode next;

        public DLinkedNode() {
        }

        public DLinkedNode(int k, int v) {
            this.key = k;
            this.value = v;
        }
    }

    private Map<Integer, DLinkedNode> cache = new HashMap<>();
    private int size;
    private int capacity;
    private DLinkedNode head, tail;

    /**
     * 以正整数作为容量capacity初始化LRU缓存
     * 
     * @param capacity
     */
    public LRUCache(int capacity) {
        this.size = 0;
        this.capacity = capacity;

        head = new DLinkedNode();
        tail = new DLinkedNode();
        head.next = tail;
        tail.prev = head;
    }

    /**
     * 
     * @param key
     * @return 如果关键字key存在于缓存中，返回其值。否则返回-1
     *         时间复杂度:O(1)
     */
    public int get(int key) {
        DLinkedNode node;
        if ((node = cache.get(key)) == null) {
            return -1;
        }
        moveToHead(node);
        return node.value;
    }

    /**
     * 如果关键字key已存在，则变更其数据值value;
     * 如果不存在，则向缓存中插入该组key-value.
     * 如果插入操作导致关键字超过capacity，则应逐出最久未使用的关键字
     * 
     * @param key
     * @param value
     *              时间复杂度:O(1)
     */
    public void put(int key, int value) {
        DLinkedNode node;
        if ((node = cache.get(key)) == null) {
            DLinkedNode newNode = new DLinkedNode(key, value);
            cache.put(key, newNode);
            addToHead(newNode);
            if (++size > capacity) {
                DLinkedNode tail = removeTail();
                cache.remove(tail.key);
                --size;
            }
        } else {
            node.value = value;
            moveToHead(node);
        }
    }

    private void addToHead(DLinkedNode node) {
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }

    private void removeNode(DLinkedNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void moveToHead(DLinkedNode node) {
        removeNode(node);
        addToHead(node);
    }

    private DLinkedNode removeTail() {
        DLinkedNode res;
        removeNode((res = tail.prev));
        return res;
    }
}
