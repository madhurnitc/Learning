package org.learn.leetcode.amazon;

import java.util.HashSet;
import java.util.Set;

public class CopyListWithRandomPointer {

    Set<Node> set = new HashSet<>();
    public Node copyRandomList(Node head) {


        if(head == null) {
            return null;
        }
        if(set.contains(head)) {
            return head;
        }
        Node newHead = new Node(head.val);
        set.add(head);

        newHead.next = copyRandomList(head.next);
        newHead.random = copyRandomList(head.random);

        return newHead;

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
}
