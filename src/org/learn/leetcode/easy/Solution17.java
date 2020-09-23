package org.learn.leetcode.easy;

import java.util.*;

public class Solution17 {
    public static int droppedRequests(List<Integer> requestTime) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int key : requestTime) {
            map.put(key, map.getOrDefault(key, 0) + 1);
        }

        int w2_max_size = 10, w3_max_size = 60;
        int w1_limit = 3, w2_limit = 20, w3_limit = 60;

        Object[] keys = map.keySet().toArray();
        Arrays.sort(keys);

        int w2_size = 0, w3_size = 0;
        int w1_req = 0, w2_req = 0, w3_req = 0;
        int dropped = 0;
        for (int i = 1; i <= (int) keys[keys.length - 1]; i++) {
            if (map.containsKey(i)) {
                w1_req = map.get(i);
                if (w1_req > w1_limit) {
                    dropped = dropped + (w1_req - w1_limit);
                }
                w2_size = w2_size + 1;
                w2_req = w2_req + w1_req;
                if (w2_size >= w2_max_size) {
                    if (w2_req > w2_limit) {
                        dropped = dropped + (w2_req - w2_limit);
                    }
                    w2_req = 0;
                    w2_size = 0;
                }
                w3_size = w3_size + 1;
                w3_req = w3_req + w1_req;
                if (w3_size >= w3_max_size) {
                    if (w3_req > w3_limit) {
                        dropped = dropped + (w3_req - w3_limit);
                    }
                    w3_req = 0;
                    w3_size = 0;
                }
            } else {
                w2_size = w2_size + 1;
                if (w2_size >= w2_max_size) {
                    if (w2_req > w2_limit) {
                        dropped = dropped + (w2_req - w2_limit);
                    }
                    w2_req = 0;
                    w2_size = 0;
                }
                w3_size = w3_size + 1;
                if (w3_size >= w3_max_size) {
                    if (w3_req > w3_limit) {
                        dropped = dropped + (w3_req - w3_limit);
                    }
                    w3_req = 0;
                    w3_size = 0;
                }
            }
        }
        if (w2_req > w2_limit) {
            dropped += w2_req - w2_limit;
        }
        if (w3_req > w3_limit) {
            dropped += w3_req - w3_limit;
        }
        return dropped;
    }

    public static void main(String[] args) {
        int[] a = {1,
                1,
                1,
                1,
                2,
                2,
                2,
                3,
                3,
                3,
                3,
                4,
                5,
                5,
                5,
                6,
                6,
                6,
                6,
                7,
                7,
                7,
                8,
                8,
                8,
                8,
                9,
                9,
                9,
                9,
                9,
                10,
                10,
                11,
                11,
                11,
                11,
                11,
                11,
                12,
                12,
                12,
                12,
                12,
                12,
                12,
                13,
                13,
                13,
                13,
                14,
                14,
                14,
                14,
                14,
                16,
                16,
                16,
                16,
                16,
                16,
                17,
                17,
                17,
                18,
                18,
                18,
                18,
                18,
                18,
                18,
                18,
                19,
                19,
                19,
                19,
                19,
                19,
                19,
                20,
                20,
                20,
                20,
                20};
        //int[] a = {1,1,1,1,2};
        //int[] a = {1,1,1,1,2,2,2,3,3,3,4,4,4,11,11,11,6,6,6,5,5,5};

        List<Integer> list = new ArrayList<>();
        for (int i : a) {
            list.add(i);
        }

        System.out.println(droppedRequests(list));
    }
}