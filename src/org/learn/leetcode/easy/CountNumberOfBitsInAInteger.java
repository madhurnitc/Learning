package org.learn.leetcode.easy;

public class CountNumberOfBitsInAInteger {

    public int countSetBits(int n) {
        int count = 0;
        while (n>0) {
            count = count + (n & 1);
            n = n >> 1;
        }

        return count;
    }


    public static void main(String[] args) {
        System.out.println(new CountNumberOfBitsInAInteger().countSetBits(5));
        System.out.println(new CountNumberOfBitsInAInteger().countSetBits(8));
    }
}
