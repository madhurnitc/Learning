package org.learn.leetcode.easy;

import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;

public class SlidingWindow {


    Deque<Integer> deq = new LinkedList<>();
    int[] nums;
    int[] result;
    int idx;

    private void buildDeq(int i, int k) {

        while(!deq.isEmpty() && deq.getFirst() <= i-k) {
            deq.removeFirst();
        }

        while ((!deq.isEmpty() && nums[i] > nums[deq.getLast()])) {
            deq.removeLast();
        }
        deq.addLast(i);

        if(i>=k-1) {
            result[i-k+1] = nums[deq.getFirst()];
        }
    }
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        if (n * k == 0) return new int[0];
        if (k == 1) return nums;

        this.nums = nums;
        this.result = new int[n - k + 1];
        for(int i =0; i<k; i++) {
            buildDeq(i, k);
        }

        for(int i =k ; i< n; i++) {
            buildDeq(i, k);
        }

        return result;
    }

    public static void main(String[] args) {
        SlidingWindow  window = new SlidingWindow();
        window.maxSlidingWindow(new int[] {1,3,-1,-3,5,3,6,7}, 3);
        System.out.println(Arrays.toString(window.result));
    }
}
