package org.learn.leetcode.easy;

import java.util.Arrays;

public class ArrayPartition1 {

    public int arrayPairSum(int[] nums) {

        int result = 0;
        int low = 0;

        Arrays.sort(nums);
        for(int i =0 ; i<nums.length ; i=i+2) {
            int min = Math.min(nums[i], nums[i+1]);
            result += min;
        }

        return result;

    }
}
