package org.learn.leetcode.medium;

public class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode head = new ListNode(0);
        ListNode current = head;
        ListNode prevNode = head;
        int carry = 0;

        while(l1!= null || l2 != null) {
            int x  = (l1 != null) ? l1.val : 0;
            int y = (l2 != null) ? l2.val : 0;
            int sum = carry + x + y;
            carry =  sum / 10;
            current = new ListNode(sum %10);
            prevNode.next = current;
            prevNode = current;

            if(l1 != null) {
                l1 = l1.next;
            }

            if (l2 != null) {
                l2 = l2.next;
            }

        }

        if(carry >0 ){
            current = new ListNode(carry);
            prevNode.next = current;
        }

        return head.next;

    }
}
