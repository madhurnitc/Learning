package org.learn.leetcode.easy;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class LongestSubStringWithAtmostTwoDistinctChar {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        if(s == null || s.length() <3) {
            return s.length();
        }

        int i = 0, j = 0;
        int length = 2;
        Map<Character, Integer> map = new HashMap<>();
        while(j < s.length()) {

            if(map.size() < 3) {
                map.put(s.charAt(j), j);
                j++;
            }

            if(map.size() ==  3) {
                int del_idx = Collections.min(map.values());
                map.remove(s.charAt(del_idx));
                i = del_idx +1;
            }

            length = Math.max(length, j-i);
        }

        return length;
    }

    public static void main(String[] args) {
        System.out.println(new LongestSubStringWithAtmostTwoDistinctChar().lengthOfLongestSubstringTwoDistinct("abaccc"));
    }
}
