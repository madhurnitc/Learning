package com.twentysix.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PartitionLabel {
    public int[] partitionLabels(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int j =0;
        for(char c : s.toCharArray()) {
            map.put(c, j);
            j++;
        }

        int start = 0;
        int end =0;
        List<Integer> result = new ArrayList<>();
        for(int i =0; i <s.length(); i++) {
            end = Math.max(end, map.get(s.charAt(i)));
            if(i == end) {
                result.add(end-start+1);
                start = end + 1;
            }
        }
        return result.stream().mapToInt(i->i).toArray();
    }
}
