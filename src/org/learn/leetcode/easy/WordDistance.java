package org.learn.leetcode.easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordDistance {


    Map<String, List<Integer>> map = new HashMap<>();

    public WordDistance(String[] words) {
        for (int i = 0; i < words.length; i++) {
            if (!map.containsKey(words[i])) {
                map.put(words[i], new ArrayList<Integer>());
            }
            map.get(words[i]).add(i);
        }
    }

    public int shortest(String word1, String word2) {

        int idx1 = 0;
        int idx2 = 0;
        int minDis = Integer.MAX_VALUE;
        List<Integer> list1 = map.get(word1);
        List<Integer> list2 = map.get(word2);

        while (idx1 < list1.size() && idx2 < list2.size()) {

            int i = list1.get(idx1);
            int j = list2.get(idx2);
            minDis = Math.min(minDis, Math.abs(i - j));

            if (i >= j) {
                idx2++;
            } else {

                idx1++;
            }
        }

        return minDis;
    }
}
