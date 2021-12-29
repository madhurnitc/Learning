package org.learn.leetcode.medium;

import java.util.HashMap;

public class LRUCache {

    private HashMap<Integer, ListNode> map;
    private DoublyLinkedList list;
    private  int capacity;
    public class ListNode {
        int value;
        int key;
        ListNode prev;
        ListNode next;

        public ListNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    public class DoublyLinkedList {
        ListNode head, tail;

        public DoublyLinkedList() {
            head = null;
            tail = null;
        }
        public void moveNodeToEnd(ListNode node) {
            if(head == node && tail != node) {
                tail.next = node;
                node.prev = tail;
                head = node.next;
            }else if (tail != node) {
                tail.next = node;
                node.prev.next = node.next;
                node.next.prev = node.prev;
                node.prev = tail;
            }

            node.next = null;
            tail = node;
        }

        public void enqueue(ListNode node) {
            if (head == null) {
                head = node;
                tail = node;
                node.prev = null;
            }else {
                tail.next = node;
                node.prev = tail;
                tail = node;
            }
            node.next = null;
        }

        public ListNode dequeue() {

            ListNode temp = null;
            if (head != null) {
                temp = head ;
                head =head.next;
            }
            return temp;

        }
    }

    public LRUCache(int capacity) {

        map = new HashMap<>(capacity);
        list = new DoublyLinkedList();
        this.capacity = capacity;
    }

    public int get(int key) {

        if(map.containsKey(key)) {
            ListNode node = map.get(key);
            list.moveNodeToEnd(node);
            return node.value;
        }

        return -1;
    }

    public void put(int key, int value) {

        if(map.containsKey(key)) {
            ListNode node = map.get(key);
            node.value = value;
            list.moveNodeToEnd(node);
        }else {

            if(map.size() == capacity) {
                ListNode leastUsed = list.dequeue();
                map.remove(leastUsed.key);
            }


            ListNode node = new ListNode(key, value);
            map.put(key, node);
            list.enqueue(node);
        }

    }

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(2);
        lruCache.put(1, 1);
        lruCache.put(2, 2);
        System.out.println(lruCache.get(1));
        lruCache.put(3, 3);
        System.out.println(lruCache.get(2));
        lruCache.put(4, 4);
        System.out.println(lruCache.get(1));
        System.out.println(lruCache.get(3));
        System.out.println(lruCache.get(4));
    }
}
