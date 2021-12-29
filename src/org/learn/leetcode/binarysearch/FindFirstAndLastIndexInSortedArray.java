package org.learn.leetcode.binarysearch;

public class FindFirstAndLastIndexInSortedArray {

    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[] {-1,-1};
        int l = 0;
        int r = nums.length-1;

        while (l < r) {

            int mid = l + (r-l)/2;
            if(nums[mid] == target) {
                r = mid;
            }else if (target < nums[mid]) {
                r = mid -1;
            }else {
                l = mid +1;
            }
        }

        if(target != nums[l]) {
            return result;
        }
        result[0] = l;

        r = nums.length-1;
        while (l<r) {
            int mid = l +(r-l)/2 + 1;
            if (nums[mid] == target) {
                l = mid;
            }else if (target < nums[mid]) {
                r = mid-1;
            }else {
                l = mid+1;
            }
        }

        result[1] = l;

        return result;


    }

    public static void main(String[] args) {
        new FindFirstAndLastIndexInSortedArray().searchRange(new int[]{5,7,7,8,8,10}, 8);
    }
}
