package com.twentysix;

import java.util.Stack;

public class LongestValidParenthesis {

    public int longestValidParentheses(String s) {
        if(s == null || s.isEmpty()) {
            return 0;
        }
        int maxLen =0;
        Stack<Integer> stack = new Stack<>();
        stack.push (-1);
        for(int i = 0; i<s.length(); i++){
            char c = s.charAt(i);
            if(c == '(') {
                stack.push(i);
            }else {
                stack.pop();
                if(stack.isEmpty()){
                    stack.push(i);
                }else{
                    maxLen = Math.max(maxLen, i-stack.peek());
                }
            }

        }

        return maxLen;
    }

}
