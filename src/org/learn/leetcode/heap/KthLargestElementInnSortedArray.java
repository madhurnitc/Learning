package org.learn.leetcode.heap;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KthLargestElementInnSortedArray {

    public int findKthLargest(int[] nums, int k) {
        int result = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o2,o1);
            }
        });


        for(int i =0; i< nums.length; i++) {

            pq.offer(nums[i]);
        }

        for(int i = 0;i<k; i++) {
            result = pq.remove();
        }

        return result;

    }
}
