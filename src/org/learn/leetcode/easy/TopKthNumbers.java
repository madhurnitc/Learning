package org.learn.leetcode.easy;

import java.util.*;

public class TopKthNumbers {

    public List<Integer> topKFrequent(int[] nums, int k) {
        TreeMap<Integer, List<Integer>> treeMap= new TreeMap(new Comparator<Integer>() {

            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });
        Map<Integer, Integer> hashMap = new HashMap<>();
        for(int num : nums) {
            hashMap.put(num, hashMap.getOrDefault(num,0) + 1);
        }

        for(Integer number : hashMap.keySet()) {

            int count = hashMap.get(number);
            if(!treeMap.containsKey(count)) {
                List<Integer> list = new ArrayList<>();
                list.add(number);
                treeMap.put(count, list);
            }else {

                List<Integer> list = treeMap.get(count);
                list.add(number);
                treeMap.put(count, list);
            }
        }

        List<Integer> result = new ArrayList<>();
        while(k>0) {
            List<Integer> values =  treeMap.pollFirstEntry().getValue();
            for(Integer i : values ) {
                result.add(i);
            }
            k = k- values.size();
        }

        return result;
    }

    public static void main(String[] args) {

        int[] nums = {1,2};
        new TopKthNumbers().topKFrequent(nums, 2);
    }
}
