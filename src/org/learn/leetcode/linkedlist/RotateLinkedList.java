package org.learn.leetcode.linkedlist;

import org.learn.leetcode.medium.ListNode;

public class RotateLinkedList {

    public ListNode rotateRight(ListNode head, int k) {
        if(head == null) {
            return head;
        }
        ListNode fastNode = head;
        ListNode slowNode = head;
        int length = 1;
        while(fastNode.next != null) {
            fastNode = fastNode.next;
            length++;
        }

        for(int i = (length-k%length); i>0 ;i--) {
            slowNode = slowNode.next;
        }

        fastNode.next = head;
        head =  slowNode.next;
        slowNode.next = null;

        return head;
    }

    public static void main(String[] args) {
        String s = "mahdhur&amp; gupta";
        s = s.replace("&amp;", "&");
        System.out.println(s);

    }
}
