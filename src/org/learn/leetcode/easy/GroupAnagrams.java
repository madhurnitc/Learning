package org.learn.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

public class GroupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        boolean[] considered = new boolean[strs.length];
        for (int i = 0; i < strs.length - 1; i++) {
            List<String> list = new ArrayList<>();
            list.add(strs[i]);
            considered[i] = true;
            for (int j = i + 1; j < strs.length; j++) {
                if ((!considered[j]) && isAnagram(strs[i], strs[j])) {
                    list.add(strs[j]);
                    considered[j] = true;
                }
            }

            list.isEmpty();

            result.add(list);
        }

        return result;
    }

    private boolean isAnagram(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }

        int[] count = new int[26];

        for (int i = 0; i < s1.length(); i++) {
            count[s1.charAt(i) - 'a']++;
            count[s2.charAt(i) - 'a']--;
        }
        for (int i : count) {
            if (i != 0) {
                return false;
            }
        }

        return true;
    }
}
