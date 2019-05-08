package org.learn.leetcode.easy;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RegEx {

    public static int getMaxOccurrences(String s, int minLength, int maxLength, int maxUnique) {
        HashMap<String, Integer> infixes = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + minLength; j <= s.length() && j - i <= maxLength; j++) {
                String subString = s.substring(i, j);
                if (infixes.containsKey(subString)) {
                    infixes.put(subString, infixes.get(subString) + 1);
                } else if (getUniqueCharacters(subString) <= maxUnique) {
                    infixes.put(subString, 1);
                }

            }
        }
        int maxFreq = 0;
        for (int freq : infixes.values()) {
            if (freq > maxFreq) maxFreq = freq;
        }
        return maxFreq;
    }

    private static int getUniqueCharacters(String string) {
        boolean[] chars = new boolean[26];
        for (int i = 0; i < string.length(); ++i) {
            chars[string.charAt(i) - 'a'] = true;
        }

        int count = 0;
        for (int i = 0; i < chars.length; ++i) {
            if (chars[i]) count++;
        }
        return count;
    }

}
