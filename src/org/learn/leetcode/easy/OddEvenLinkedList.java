package org.learn.leetcode.easy;

import org.learn.leetcode.medium.ListNode;

public class OddEvenLinkedList {

    public ListNode oddEvenList(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode evenList = head.next;
        ListNode oddList = head;

        ListNode evenPtr = head.next.next;

        while (oddList.next != null && evenList.next != null) {
            oddList.next = oddList.next.next;
            evenList.next = evenList.next.next;
            oddList = oddList.next;
            evenList = evenList.next;
        }

        oddList.next = evenPtr;

        return oddList;

    }
}
