package org.learn.leetcode.easy;

import org.learn.leetcode.medium.ListNode;

public class PallindromeLinkedList {

    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }

        ListNode slowPtr = head;
        ListNode fastPtr = head;
        while (fastPtr != null && fastPtr.next != null) {

            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;
        }

        if (fastPtr != null) {
            slowPtr = slowPtr.next;
        }

        fastPtr = head;
        ListNode reverseList = reverse(slowPtr);

        return isPalindrome(fastPtr, reverseList);
    }

    private ListNode reverse(ListNode node) {
        ListNode prev = null;
        ListNode curr = node;

        while (curr != null) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }

        return curr;
    }

    private boolean isPalindrome(ListNode l1, ListNode l2) {

        while (l2 != null) {

            if (l1.val != l2.val) {
                return false;
            }

            l1 = l1.next;
            l2 = l2.next;
        }

        return true;
    }

    public static void main(String[] args) {
        ListNode a = new ListNode(1);

        ListNode b = new ListNode(2);
        a.next = b;

        new PallindromeLinkedList().isPalindrome(a);
    }
}
