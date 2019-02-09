package org.learn.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

public class RepeatedNTimes {

    public int repeatedNTimes(int[] A) {

        Map<Integer, Integer> map = new HashMap<Integer,Integer>();

        for(int x : A) {

            if(!map.containsKey(x)){
                map.put(x,1);
            }else {
                map.put(x, map.get(x) +1);
                return x;
            }
        }

        throw null;
    }
}
