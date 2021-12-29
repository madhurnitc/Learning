package org.learn.leetcode.binarysearch;

public class SearchInRoatateSortedArray {

    public int search(int[] nums, int target) {

        int lo = 0;
        int hi = nums.length-1;
        while (lo<=hi) {

            int mid = lo + (hi-lo)/2;
            if(nums[mid] == target) {
                return mid;
            }else if (nums[lo] <= nums[mid]) {   // if this part is sorted
                if(target>=nums[lo] && target<nums[mid]) { // if target is in this sorted part
                    hi = mid-1;
                }else {
                   lo = mid+1;
                }

            }else { // if this part is sorted
                if(target > nums[mid] && target <= nums[hi]) { // if target is in this sorted part
                    lo = mid + 1;
                }else {
                    hi = mid-1;
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new SearchInRoatateSortedArray().search(new int[] {4,5,6,7,0,1,2},0));
    }
}
