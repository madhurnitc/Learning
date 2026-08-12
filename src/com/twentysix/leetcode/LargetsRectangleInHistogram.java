package com.twentysix.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

public class LargetsRectangleInHistogram {

    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        Deque<Integer> stack = new ArrayDeque<>(); // stores indices, increasing height
        int maxArea = 0;

        for(int i =0; i<n; i++){

            int currenHeight = i == n ? 0: heights[i];
            while(!stack.isEmpty() && heights[stack.peek()] >= currenHeight) {
                int height = heights[stack.pop()];
                int width = stack.isEmpty() ? i : i-stack.peek()-1;
                maxArea = Math.max(maxArea, width*height);
            }
            stack.push(i);
        }
        return maxArea;
    }

}
