package org.learn.hackerrank;

import java.util.HashMap;
import java.util.Map;

public class SockMerchant {

    static int sockMerchant(int n, int[] ar) {

        Map<Integer, Integer> map = new HashMap<>();
        for(int i : ar) {
            map.put(i, map.getOrDefault(i, 0)+1);
        }

        int result = 0;

        for(Integer count: map.values()) {

            result = result + count/2;
        }

        return result;

    }
}
