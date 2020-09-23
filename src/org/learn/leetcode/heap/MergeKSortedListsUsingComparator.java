package org.learn.leetcode.heap;

import org.learn.leetcode.medium.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKSortedListsUsingComparator {

    public ListNode mergeKLists(ListNode[] lists) {
        ListNode result = null;
        ListNode prev = null;
        PriorityQueue<ListNode> pq = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return Integer.compare(o1.val, o2.val);
            }
        });

        for(ListNode list : lists) {
            pq.add(list);
        }

        while(!pq.isEmpty()) {
            if (result != null) {
                ListNode node = new ListNode(pq.poll().val);
                prev.next = node;
                prev = node;
            }else {
                result = new ListNode(pq.poll().val);
                prev = result;
            }
        }
        return result;
    }
}
