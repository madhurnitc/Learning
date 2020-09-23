package org.learn.leetcode.easy;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class ValidPalindrome {

    public boolean isPalindrome(String s) {


        if (s == null || s.isEmpty()) {
            return true;
        }

        int low = 0;
        int high = s.length() - 1;

        while (low <= high) {
            if (!Character.isLetterOrDigit(s.charAt(low))) {
                low++;
            } else if (!Character.isLetterOrDigit(s.charAt(high))) {
                high--;
            } else {

                if (Character.toLowerCase(s.charAt(low)) != Character.toLowerCase(s.charAt(high))) {
                    return false;
                }

                low++;
                high--;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(new ValidPalindrome().isPalindrome("race a car"));
    }
}
