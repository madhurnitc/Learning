package org.learn.leetcode.heap;

import java.util.*;

public class TopKElementsInArray {


    public int[] topKFrequent(int[] nums, int k) {
        int[] result = new int[k];
        PriorityQueue<Number> pq = new PriorityQueue<>(new Comparator<Number>() {
            @Override
            public int compare(Number o1, Number o2) {
                return Integer.compare(o2.count, o1.count);
            }
        });

        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i< nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) +1);
        }

        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            Number number = new Number(entry.getKey(), entry.getValue());
            pq.offer(number);
        }

        for (int i = 0; i<k;i++) {
            result[i] = pq.remove().num;
        }

        return result;
    }

    public class Number {
        private int num;
        private int count;
        public Number(int num, int count) {
            this.num = num;
            this.count = count;
        }
    }

    public static void main(String[] args) {
        int[] input = {1,1,1,2,2,3};
        new TopKElementsInArray().topKFrequent(input, 2);
    }
}
