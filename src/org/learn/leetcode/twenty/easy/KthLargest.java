package org.learn.leetcode.twenty.easy;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KthLargest {
    private int size;
    private PriorityQueue<Integer> pq = null;
    public KthLargest(int k, int[] nums) {
        this.size = k;
        pq = new PriorityQueue<>();
        for(int num : nums) {
            pq.offer(num);
        }

    }

    public int add(int val) {
        pq.offer(val);
        while(pq.size() > this.size) {
            pq.poll();
        }
        return pq.peek();
    }

    public static void main(String[] args) {
        new KthLargest(3, new int[]{4,5,8,2}).add(3);
    }
}
