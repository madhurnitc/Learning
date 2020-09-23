package org.learn.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

class LRUCache {

    Map<Integer, Node> map;
    DoublyLinkedList list;

    int capacity;

    public class Node {
        int key, value;
        Node next, prev;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
    public class DoublyLinkedList {

        Node head, tail;

        public DoublyLinkedList() {
            head = null;
            tail = null;
        }

        public void moveItemToEnd(Node n) {

            if (head == n && tail != n) {

                tail.next = n;
                n.prev = tail;
                head = head.next;

            } else if (tail != n) {

                tail.next = n;
                n.prev.next = n.next;
                n.next.prev = n.prev;
                n.prev = tail;

            }
            n.next = null;
            tail = n;

        }

        public void enqueue(Node n) {
            if (head == null) {
                head = n;
                tail = n;
                n.prev = null;
            } else {
                n.prev = tail;
                tail.next = n;
                tail = n;
            }

            n.next = null;
        }

        public Node dequeue() {

            Node temp = null;
            if (head != null) {
                temp = head;
                head = head.next;
            }

            return temp;
        }
    }

    public LRUCache(int capacity) {
        map = new HashMap<>();
        list = new DoublyLinkedList();
        this.capacity = capacity;
    }

    public int get(int key) {

        if (map.containsKey(key)) {
            Node n = map.get(key);
            list.moveItemToEnd(n);
            return n.value;
        }

        return -1;

    }

    public void put(int key, int value) {

        if (map.containsKey(key)) {
            Node n = map.get(key);
            n.value = value;
            list.moveItemToEnd(n);
        } else {

            if (map.size() == capacity) {

                Node leastUsed = list.dequeue();
                map.remove(leastUsed.key);

            }

            Node n = new Node(key, value);
            map.put(key, n);
            list.enqueue(n);
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