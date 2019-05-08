package org.learn.leetcode.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindAndReplacePattern {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> result = new ArrayList<>();
        for(String word : words) {

            if(word.length() == pattern.length()) {
                Map<Character, Character> map = new HashMap<>();
                boolean shouldAdd = false;
                for(int i =0 ; i < word.length(); i++) {

                    if(map.containsKey(word.charAt(i))) {
                        if(map.get(word.charAt(i)) != pattern.charAt(i)) {
                            shouldAdd = false;
                            break;
                        }
                    } else {
                        map.put(word.charAt(i), pattern.charAt(i));
                        shouldAdd = true;
                    }
                }

                if(shouldAdd) {
                    result.add(word);
                }

            }
        }
        return result;
    }

}
