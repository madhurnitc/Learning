package org.learn.leetcode.easy;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstring {

    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int ans = 0, i = 0, j = 0;
        Set<Character> set = new HashSet<>();

        while (i < n && j < n) {

            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j));
                j++;
                ans = Math.max(ans, j - i);
            } else {
                set.remove(s.charAt(i++));
            }

        }
        return ans;
    }

    public static void main(String[] args) {
        new LongestSubstring().lengthOfLongestSubstring("pwwkew");
    }
}
