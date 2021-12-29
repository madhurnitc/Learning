package org.learn.leetcode.amazon;

import org.learn.leetcode.medium.ListNode;

public class SortList {
    public ListNode sortList(ListNode head) {

        if(head == null || head.next == null) {
            return head;
        }
        ListNode slowPtr = head;
        ListNode fastPtr = head;
        ListNode prev = null;
        while(fastPtr != null && fastPtr.next != null) {
            prev = slowPtr;
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;
        }

        prev.next = null;
        fastPtr = head;
        ListNode l1 = sortList(fastPtr);
        ListNode l2 = sortList(slowPtr);

        return merge(l1, l2);


    }

    private ListNode merge(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(-1);
        ListNode current = head;
        while(l1 != null || l2 != null){
            if(l1 == null) {
                current.next = l2;
                l2 = l2.next;
            }else if (l2 == null) {
                current.next = l1;
                l1 = l1.next;
            }else if (l1.val <= l2.val) {
                current.next = l1;
                l1 = l1.next;
            }else {
                current.next = l2;
                l2 = l2.next;
            }

            current = current.next;
        }
        return head.next;
    }
}
