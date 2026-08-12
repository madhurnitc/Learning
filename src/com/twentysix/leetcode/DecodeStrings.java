package com.twentysix.leetcode;

import java.util.Stack;

public class DecodeStrings {
    public String decodeString(String s) {
        if(s == null || s.isEmpty()) {
            return null;
        }

        Stack<String> sStack = new Stack<>();
        Stack<Integer> nStack = new Stack<>();
        int currNumber =0;
        String currString = "";
        for(int i = 0; i< s.length(); i++){

            char c = s.charAt(i);
            if(c=='[') {
                sStack.push(currString);
                nStack.push(currNumber);
                currNumber = 0;
                currString = "";
            }else if(c == ']') {
                int num = nStack.pop();
                String prevString = sStack.pop();
                currString = prevString + currString.repeat(num);
            }else if (Character.isDigit(c)) {
                currNumber = currNumber*10 + c-'0';
            }else {
                currString+=c;
            }
        }
        return currString;
    }
}
