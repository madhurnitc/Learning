package org.learn.leetcode.string;

public class LongestPalindromicSubstring {
    private int startIndex =0;
    private int len=0;
    public String longestPalindrome(String s) {

        for (int i =0; i<s.length(); i++) {
            expandAroundMid(s, i, i);
            expandAroundMid(s, i, i+1);

        }

        return s.substring(startIndex, startIndex +len);
    }


    private  void expandAroundMid (String s,int left, int right) {
        while(left >=0 && right<s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        if(len < right-left +1 ) {
            len = right-left+1;
            startIndex = left +1;
        }
    }

    public static void main(String[] args) {
        new LongestPalindromicSubstring().longestPalindrome("babad");
    }
}
