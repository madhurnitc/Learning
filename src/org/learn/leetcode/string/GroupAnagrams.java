package org.learn.leetcode.string;

import java.util.ArrayList;
import java.util.List;

public class GroupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        boolean[] considered = new boolean[strs.length];

        for(int i = 0; i<strs.length; i++) {
            List<String> list = new ArrayList<>();
            for(int j = i; j<strs.length; j++) {
                if(!considered[j] && isAnagram(strs[i], strs[j])) {
                    list.add(strs[j]);
                    considered[j] = true;
                }
            }
            if(!list.isEmpty()) {
                result.add(list);
            }
        }

        return result;
    }

    public boolean isAnagram(String str1, String str2) {
        if(str1.length() != str2.length()) {
            return false;
        }

        int[] count = new int[26];
        for(int i = 0; i<str1.length(); i++) {

            count[str1.charAt(i)-'a']++;
            count[str2.charAt(i)-'a']--;
        }

        for(int i =0; i < count.length; i++) {
            if(count[i] != 0) {
                return false;
            }
        }

        return true;
    }
}
