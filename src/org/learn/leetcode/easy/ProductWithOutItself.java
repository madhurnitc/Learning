package org.learn.leetcode.easy;

import java.util.Arrays;

public class ProductWithOutItself {

    public int[] productExceptSelf(int[] nums) {

        int N = nums.length;
        int[] result = new int[N];
        Arrays.fill(result, 1);
        int i;
        for (i = 1; i < N; i++) {
            result[i] = result[i - 1] * nums[i - 1];
        }

        int m = 1;
        for (i = N - 1; i >= 0; i--) {

            result[i] = result[i] * m;
            m = m * nums[i];
        }

        return result;
    }

    public static void main(String[] args) {

        int[] a = {1, 2, 3, 4};
        new ProductWithOutItself().productExceptSelf(a);
    }
}
