package org.learn.leetcode.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 1; i++) {

            if (i == 0 || (i > 0 && nums[i] != nums[i - 1])) {
                int lo = i + 1, high = nums.length - 1;
                int sum = 0 - nums[i];
                while (lo < high) {
                    if (nums[lo] + nums[high] == sum) {
                        result.add(Arrays.asList(nums[i], nums[lo], nums[high]));
                        while (nums[lo] == nums[lo + 1]) {
                            lo++;
                        }
                        while (nums[high] == nums[high - 1]) {
                            high--;
                        }
                    } else if (nums[lo] + nums[high] < sum) {
                        lo++;
                    } else {
                        high--;
                    }
                }
            }

        }

        return result;
    }
}
