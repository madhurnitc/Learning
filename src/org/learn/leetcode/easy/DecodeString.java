package org.learn.leetcode.easy;

import java.util.Stack;

public class DecodeString {
    public String decodeString(String s) {
        Stack<StringBuilder> string = new Stack<>();
        //string.push(new StringBuilder());
        Stack<Integer> count = new Stack<>();
        int i = 0;
        while(i<s.length()) {

            char ch = s.charAt(i);
            if(Character.isDigit(ch)) {
                int number = 0;
                while(Character.isDigit(s.charAt(i))) {
                    number =  number*10 + (s.charAt(i)-'0');
                    i++;
                }
                count.push(number);

            }else if (ch == '[') {
                string.push(new StringBuilder());
                i++;

            }else if (ch == ']') {
                String current  = string.pop().toString();
                int times  = count.pop();
                StringBuilder temp = new StringBuilder();
                for(int j  = 0; j< times; j++) {
                    temp.append(current);
                }

                string.push(string.pop().append(temp.toString()));
                i++;

            }else{
                string.peek().append(ch);
                i++;
            }


        }

        return string.pop().toString();
    }

    public static void main(String[] args) {
        new DecodeString().decodeString("3[a]2[bc]");
    }
}
