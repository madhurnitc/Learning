package org.learn.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length-2; i++) {
            if(nums[i] >0 ) {
                break;
            }
            if(i==0 || i>0 && nums[i] != nums[i-1]) {
                int lo = i+1 , hi = nums.length-1;
                int sum = 0-nums[i];
                while(lo<hi) {
                    if(nums[lo] + nums[hi] == sum) {
                        result.add(Arrays.asList(nums[i], nums[lo], nums[hi]));
                        while(lo<hi && nums[lo] == nums[lo+1]) {
                            lo++;
                        }
                        while(lo<hi && nums[hi] == nums[hi-1]) {
                            hi--;
                        }
                        lo++;
                        hi--;
                    }else if (nums[lo] + nums[hi] <sum) {
                        lo++;
                    }else {
                        hi--;
                    }
                }
            }


        }

        return result;
    }

    public static void main(String[] args) {
        ThreeSum obj = new ThreeSum();
        int[] input = {-1,0,1,2,-1,-4};
        obj.threeSum(input);
    }
}
