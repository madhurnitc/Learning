package org.learn.leetcode.easy;

public class HammingDistance {

    public int hammingDistance(int x, int y) {


           int result = x^y;
           return Integer.bitCount(result);

    }

    public static void main(String [] args) {

        HammingDistance hd = new HammingDistance();

        System.out.println(hd.hammingDistance(1,4 ));
    }
}
