package org.learn.leetcode.easy;

public class CompressString {
    public int compress(char[] chars) {
        int anchor = 0, write = 0;

        for (int read = 0; read < chars.length; read++) {
            if (read + 1 == chars.length || chars[read] != chars[read + 1]) {
                chars[write++] = chars[anchor];
                if (anchor < read) {

                    int lengthOfChar = read - anchor + 1;
                    chars[write++] = Integer.toString(lengthOfChar).charAt(0);
                }

                anchor = read + 1;
            }


        }

        return write;

    }

    public static void main(String[] args) {
        new CompressString().compress(new char[]{'a', 'a', 'a', 'b', 'b', 'c', 'c', 'c'});
    }
}
