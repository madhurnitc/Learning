package org.learn.leetcode.twenty.medium;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class NextGreateNumber {

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {

        Map<Integer,Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();

        for(int i = nums2.length-1; i >= 0; i--) {
            while(!stack.isEmpty() && nums2[i] > stack.peek()) {
                stack.pop();
            }
            map.put(nums2[i], stack.isEmpty()? -1: stack.peek());
            stack.push(nums2[i]);

        }

        for(int j = 0; j<nums1.length; j++) {
            nums1[j] = map.getOrDefault(nums1[j], -1);
        }
        return nums1 ;
    }
}
