package org.learn.leetcode.easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ArrayInterSection {

    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> count = new HashMap<>();
        List<Integer> arrList = new ArrayList<>();
        for(int i : nums1) {

        }

        for(int i = 0; i<nums2.length ;i++) {
            if( count.containsKey(nums2[i]) && count.get(nums2[i])>0) {
                arrList.add(nums2[i]);
                count.put(nums2[i], count.get(nums2[i])-1);
            }
        }

        int[] result = new int[arrList.size()];
        for(int i = 0; i<arrList.size(); i++) {
            result[i] = arrList.get(i);
        }

        return result;
    }
}
