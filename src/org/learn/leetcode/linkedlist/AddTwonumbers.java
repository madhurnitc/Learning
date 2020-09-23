package org.learn.leetcode.linkedlist;

import org.learn.leetcode.medium.ListNode;

import java.util.Stack;

public class AddTwonumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode result = null;
        ListNode head = null;
        ListNode prev = null;
        int carry = 0;

        while( l1 != null || l2 !=null) {

            int sum = carry;
            if(l1 != null) {
                sum = sum + l1.val;
                l1= l1.next;
            }

            if (l2 != null) {
                sum = sum + l2.val;
                l2= l2.next;
            }

            int nodeVal = sum%10;
            carry = sum/10;
            result = new ListNode();
            result.val = nodeVal;
            if (head == null) {
                head = result;
            }else {
                prev.next = result;
            }
            prev = result;
        }

        if (carry>0) {
            prev.next = new ListNode(carry);
        }

        return head;
    }
}


