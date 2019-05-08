package org.learn.leetcode.easy;

import java.util.Stack;

class MinStack {


    Stack<Integer> normalStack ;
    Stack<Integer> minStack;
    /** initialize your data structure here. */
    public MinStack() {
        normalStack = new Stack<>();
        minStack = new Stack<>();

    }

    public void push(int x) {
        if(normalStack.empty()) {
            minStack.push(x);
        }else {

            if(x<= minStack.peek()) {
                minStack.push(x);
            }
            normalStack.push(x);
        }
    }

    public void pop() {
         normalStack.pop();
    }

    public int top() {
        return normalStack.peek();
    }

    public int getMin() {
        return minStack.pop();
    }
}