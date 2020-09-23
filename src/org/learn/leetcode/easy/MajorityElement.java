package org.learn.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

public class MajorityElement {

    public int majorityElement(int[] nums) {
        Map<Integer, Integer> counts = new HashMap<>();

        for (int num : nums) {
            counts.put(num, counts.getOrDefault(num,0)+1);
        }

        int maxCount = -1;
        int maxElm = -1;
        for (Map.Entry<Integer, Integer> entry : counts.entrySet()){

            if (entry.getValue() > maxCount) {
                maxCount = entry.getValue();
                maxElm = entry.getKey();
            }
        }

        return maxElm;
    }
}
