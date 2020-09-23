package org.learn.leetcode.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindAndReplacePattern2 {

    public List<String> findAndReplacePattern(String[] words, String pattern) {

        List<String> result = new ArrayList<>();
        for (String word : words) {

            if (word.length() == pattern.length()) {
                result.add(word);
                Map<Character, Character> map = new HashMap<>();
                for (int i = 0; i < word.length(); i++) {

                    if (map.containsKey(word.charAt(i))) {
                        if (map.get(word.charAt(i)) != pattern.charAt(i)) {
                            result.remove(result.size() - 1);
                            break;
                        }
                    } else {
                        map.put(word.charAt(i), pattern.charAt(i));
                    }
                }
            }
        }
        return result;
    }
}
