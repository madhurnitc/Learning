package org.learn.leetcode.easy;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParenThesis {

    public boolean isValid(String s) {

        Map<Character, Character> mapping = new HashMap<>();

        mapping.put('}', '{');
        mapping.put(')', '(');
        mapping.put(']', '[');

        Stack<Character> openParStack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {

            char c = s.charAt(i);
            if (c == '{' || c == '[' || c == '(') {
                openParStack.push(c);
            } else {
                char popPar = openParStack.pop();
                if (mapping.get(c) != popPar) {
                    return false;
                }

            }
        }

        return openParStack.empty();
    }

    public static void main(String[] args) {
        System.out.println(new ValidParenThesis().isValid("()[]{}"));
        ;
    }
}
