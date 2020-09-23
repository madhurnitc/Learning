package org.learn.leetcode.binarysearch;

import java.util.*;

public class IntersectionOfArrays {

    public int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> list = new ArrayList<>();
        Map<Integer,Integer> map = new HashMap<>();

        for(int num : nums1) {
            map.put(num, map.getOrDefault(num,0) +1);
        }

        for(int num : nums2) {
            if (map.containsKey(num) && map.get(num) >0) {
                list.add(num);
                map.put(num, map.get(num)-1);
            }
        }

        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}
