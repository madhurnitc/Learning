package org.learn.leetcode.heap;

import org.learn.leetcode.medium.ListNode;

import java.util.PriorityQueue;

public class MergeKSortedLists {

    public ListNode mergeKLists(ListNode[] lists) {

        ListNode result = null;
        ListNode prev = null;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for ( ListNode list : lists) {
            ListNode head = list;
            while (head != null) {
                pq.offer(head.val);
                head = head.next;
            }
        }

        while (!pq.isEmpty()) {

            if (result == null) {
                result = new ListNode(pq.poll());
                prev = result;
            } else {
                ListNode node = new ListNode(pq.poll());
                prev.next = node;
                prev = node;
            }
        }

        return result;
    }
}
