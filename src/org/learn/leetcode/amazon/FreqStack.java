package org.learn.leetcode.amazon;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class FreqStack {

        Map<Integer, Integer> frequency;
        Map<Integer, Stack<Integer>> group;
        int maxFreq ;

        public FreqStack() {
            frequency = new HashMap<>();
            group = new HashMap<>();
            maxFreq = 0;

        }

        public void push(int x) {
            int f = frequency.getOrDefault(x, 0) +1;
            frequency.put(x, f);
            if(f > maxFreq) {
                maxFreq = f;
            }

            group.computeIfAbsent(f,z-> new Stack<>()).push(x);

        }

        public int pop() {

            int x = group.get(maxFreq).pop();
            frequency.put(x, frequency.get(x)-1);
            if(group.get(maxFreq).size() == 0){
                maxFreq--;
            }

            return x;

        }
    public static void main(String[] args) {

        FreqStack mfs = new FreqStack();
        mfs.push(5);
        mfs.push(7);
        mfs.push(5);
        mfs.push(7);
        mfs.push(4);
        mfs.push(5);
        mfs.pop();
        mfs.pop();
        mfs.pop();
        mfs.pop();
    }

}
