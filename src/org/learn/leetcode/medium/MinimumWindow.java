package org.learn.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindow {


    public String minWindow(String s, String t) {
        if( s== null || t == null || s.isEmpty() || t.isEmpty() || s.length() < t.length()) {
            return "";
        }

        Map<Character, Integer> map = new HashMap<>();

        for(int i = 0 ; i < t.length() ; i++) {
            char tChar = t.charAt(i);
            map.put(tChar, map.getOrDefault(tChar,0) + 1);
        }

        int start = 0, end = 0 , left = 0 , right = s.length()-1, minLength = s.length();
        int count = map.size();
        boolean found = false ;
        while (end < s.length()) {

            char sChar = s.charAt(end++);
            if(map.containsKey(sChar)) {
                map.put(sChar, map.get(sChar)-1);
                if(map.get(sChar) == 0) {
                    count-=1;
                }
            }

            if(count > 0) {
                continue;
            }

            while(count == 0) {
                char sStartChar = s.charAt(start++);
                if(map.containsKey(s.charAt(sStartChar))) {
                    map.put(sStartChar, map.get(sStartChar)+1);
                    if(map.get(sStartChar) > 0) {
                        count+=1;
                    }
                }

            }

            if(minLength > end-start) {
                left = start;
                right = end;
                minLength = end-start;
                found = true;
            }
        }

        return !found ? "" : s.substring(left-1, right);

    }

    public static void main(String[] args) {
        new MinimumWindow().minWindow("ADOBECODEBANC", "ABC");
    }
}
