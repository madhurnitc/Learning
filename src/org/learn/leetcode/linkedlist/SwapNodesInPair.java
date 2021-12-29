package org.learn.leetcode.linkedlist;

import org.learn.leetcode.medium.ListNode;

public class SwapNodesInPair {

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode firstNode = head;
        ListNode secondNode = head.next;
        ListNode prev = null;
        ListNode newHead = head.next;
        while(firstNode != null &&  secondNode != null) {
            firstNode.next = secondNode.next;
            secondNode.next = firstNode;
            if(prev != null) {
                prev.next = secondNode;
            }

            if(firstNode.next == null) {
                break;
            }
            prev = firstNode;
            firstNode = firstNode.next;
            secondNode = firstNode.next;
        }

        return newHead;
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        n1.next = new ListNode(2);
        n1.next.next = new ListNode(3);
        n1.next.next.next = new ListNode(4);
        ListNode head = n1;
        new SwapNodesInPair().swapPairs(head);
    }
}
