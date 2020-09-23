package org.learn.leetcode.twenty.medium;

import org.learn.leetcode.medium.ListNode;

public class LinkedListCycleDetection {

    public ListNode detectCycle(ListNode head) {

        if(head == null) {
            return head;
        }

        ListNode slwPtr = head;
        ListNode fstPtr = head;
        while(fstPtr != null && fstPtr.next != null) {
            slwPtr = slwPtr.next;
            fstPtr = fstPtr.next.next;
            if(slwPtr == fstPtr) {
                break;
            }
        }

        if(fstPtr == null || fstPtr.next == null) {
            return null;
        }

        fstPtr = head;
        while(fstPtr != slwPtr) {
            fstPtr = fstPtr.next;
            slwPtr = slwPtr.next;
        }

        return slwPtr;



    }
}
