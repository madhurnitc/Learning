package org.learn.leetcode.amazon;

import java.util.Stack;

public class DailyTemperatures {

    public int[] dailyTemperatures(int[] T) {

        int end = T.length-1;
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[T.length];

        while(end >=0) {
            int currTemp = T[end];

            while(!stack.isEmpty() && currTemp > T[stack.peek()]) {
                stack.pop();
            }

            int diff = stack.isEmpty() ? 0 : stack.peek()-end;
            result[end] = diff;
            stack.push(end--);

        }

        return result;
    }


    public static void main(String[] args) {
        int[] temp = {89,62,70,58,47,47,46,76,100,70};

        new DailyTemperatures().dailyTemperatures(temp);
    }
}
