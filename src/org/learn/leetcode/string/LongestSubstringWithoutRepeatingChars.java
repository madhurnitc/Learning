package org.learn.leetcode.string;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingChars {

    public int lengthOfLongestSubstring(String s) {

        int result = 0;
        Set<Character> set = new HashSet<>();
        int i = 0, j =0;

        while (i < s.length() && j < s.length()) {
            if(!set.contains(s.charAt(j))) {
                set.add(s.charAt(j++));
                result = Math.max(result, j-i);
            }else {

                set.remove(s.charAt(i++));
            }

        }
        return  result;
    }
}
