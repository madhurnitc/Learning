package org.learn.leetcode.amazon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombination {

    Map<String, String> phone = new HashMap<String, String>() {{
        put("2", "abc");
        put("3", "def");
        put("4", "ghi");
        put("5", "jkl");
        put("6", "mno");
        put("7", "pqrs");
        put("8", "tuv");
        put("9", "wxyz");
    }};

    List<String> result = new ArrayList<>();
    public List<String> letterCombinations(String digits) {

        if(digits.length() != 0) {
            backtracking("", digits);
        }

        return result;

    }

    public void backtracking(String combination, String next_digit) {

        if(next_digit.length() == 0) {
            result.add(combination);
        }

        String digit = next_digit.substring(0,1);
        String letters = phone.get(digit);

        for(int i =0; i < letters.length(); i++) {
            String letter = letters.substring(0,1);
            backtracking(combination+letter, next_digit.substring(1));

        }
    }
}
