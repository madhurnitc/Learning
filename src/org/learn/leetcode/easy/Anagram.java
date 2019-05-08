package org.learn.leetcode.easy;

public class Anagram {

    public boolean isAnagram(String s, String t) {

        String ss= s+s;
        return ss.indexOf(t) > -1;

    }
}
