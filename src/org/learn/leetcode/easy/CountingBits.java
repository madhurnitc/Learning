package org.learn.leetcode.easy;

public class CountingBits {

    public int[] countBits(int num) {

        int[] result = new int[num + 1];
        for (int i = 0; i <= num; i++) {
            for (int j = 0; j < 32; j++) {

                int temp = (i >> j);
                result[i] = result[i] + (temp & 1);
            }
        }

        return result;
    }

    public static void main(String[] args) {


        System.out.println(new CountingBits().countBits(4));
    }
}
