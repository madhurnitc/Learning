package org.learn.leetcode.easy;

public class ReverseBits {

    public int reverseBits(int n) {
        int answer = 0; // initializing answer
        for (int i = 0; i < 32; i++) { // 32 bit integers
            answer = answer << 1; // shifts answer over 1 to open a space
            answer = answer | ((n >> i) & 1); // inserts bits from n
        }
        return answer;
    }
}
