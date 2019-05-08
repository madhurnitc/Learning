package org.learn.leetcode.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        return getResult(candidates, target, result, curr, 0);
    }

    private List<List<Integer>> getResult(int[] candidates, int target, List<List<Integer>> result, List<Integer> curr, int startPos) {

        if(target>0) {

            for(int i =startPos; i<candidates.length && target>=candidates[i]; i++) {
                curr.add(candidates[i]);
                getResult(candidates, target-candidates[i],result, curr,i);
                curr.remove(curr.size()-1);
            }
        }else if (target == 0) {
            result.add(new ArrayList<>(curr));
        }

        return result;
    }

    public static void main(String[] args) {
        new CombinationSum().combinationSum(new int[] {2,3,6,7}, 7);
    }
}
