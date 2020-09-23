package org.learn.leetcode.heap;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.PriorityQueue;

public class MaximumSlidingWindow {

    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> dq = new ArrayDeque<>();
        int[] result = new int[nums.length-k+1];
        for(int i =0 ; i< nums.length; i++) {

            if(!dq.isEmpty() && dq.peekFirst() <i-k+1 ) {
                dq.pollFirst();
            }
            while(!dq.isEmpty() && nums[dq.peekLast()]< nums[i]) {
                dq.pollLast();
            }
            dq.offer(i);
            if(i-k+1>=0) {
                result[i-k+1] = nums[dq.peekFirst()];
            }
        }

        return result;

    }

    public static void main(String[] args) {
        int[] input = {1,3,-1,-3,5,3,6,7};
        new MaximumSlidingWindow().maxSlidingWindow(input, 3);
    }
}
