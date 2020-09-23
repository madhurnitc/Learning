package org.learn.leetcode.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubSetsInDistinctNumbers {

    public List<List<Integer>> subsets(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> internalList = new ArrayList<>();
        return subsetsInternal(nums, 0, result, internalList);
    }

    private List<List<Integer>> subsetsInternal(int[] nums, int start, List<List<Integer>> result, List<Integer> temp) {

        result.add(new ArrayList<>(temp));

        for (int i = start; i < nums.length; i++) {
            temp.add(nums[i]);
            subsetsInternal(nums, i + 1, result, temp);
            temp.remove(temp.size() - 1);
        }

        return result;
    }

    public static void main(String[] args) {
        new SubSetsInDistinctNumbers().subsets(new int[]{10, 20});
    }
}
