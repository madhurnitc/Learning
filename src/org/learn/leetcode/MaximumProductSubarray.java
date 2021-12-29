package org.learn.leetcode;

public class MaximumProductSubarray {

    public int maxProduct(int[] nums) {

        int maxSoFar = nums[0];
        int maxEndHere = nums[0];
        int minEndHere = nums[0];

        for (int i =1 ; i< nums.length;  i++) {

            if (nums[i] < 0) {
                //swap(maxEndHere, minEndHere);
                int temp = maxEndHere;
                maxEndHere = minEndHere;
                minEndHere = temp;
            }

            maxEndHere =  Math.max(nums[i], maxEndHere*nums[i]);
            minEndHere = Math.min(nums[i], minEndHere*nums[i]);

            maxSoFar = Math.max(maxSoFar, Math.max(maxEndHere, minEndHere));
        }

        return maxSoFar;
    }

    private void swap(int i , int j) {
        int temp = i;
        i = j;
        j = temp;
    }

    public static void main(String[] args) {
        int[] nums = new int[] {2,3,-2,4};
        new MaximumProductSubarray().maxProduct(nums);
    }

}
