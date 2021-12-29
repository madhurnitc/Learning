package org.learn.leetcode.linkedlist;

import org.learn.leetcode.medium.ListNode;

public class RemoveNthNodeFromEnd {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode slwPt = head;
        ListNode fstPtr = head;
        while(n > 0) {
            fstPtr= fstPtr.next;
            n--;
        }

        if(fstPtr == null) {
            return head.next;
        }

        while (fstPtr.next !=null) {
            slwPt = slwPt.next;
            fstPtr = fstPtr.next;
        }

        slwPt.next = slwPt.next.next;

        return head;
    }
}
