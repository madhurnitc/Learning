package org.learn.leetcode.medium;

import java.util.Stack;

public class MakeParenthesisValid {
    public int minAddToMakeValid(String S) {
        int result = 0;
        int count = 0;
        if (S.length() == 0) return result;
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == '(') {
                stack.push(S.charAt(i));
            } else if (S.charAt(i) == ')') {
                if (stack.empty()) {
                    count++;
                } else {
                    stack.pop();
                }
            }
        }

        return stack.size() + count;
    }
}
