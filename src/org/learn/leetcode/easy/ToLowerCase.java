package org.learn.leetcode.easy;

public class ToLowerCase {

    public String toLowerCase(String str) {
        char[] lower = str.toCharArray();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) >= 'A' && str.charAt(i) <= 'Z') {
                int asciVal = (int) str.charAt(i) + 32;
                char lowerChar = (char) (asciVal);
                lower[i] = lowerChar;
            }
        }
        return String.valueOf(lower);
    }

    public static void main(String[] args) {

        ToLowerCase Tlc = new ToLowerCase();

        System.out.println(Tlc.toLowerCase("Hello"));
        System.out.println(Tlc.toLowerCase("here"));
        System.out.println(Tlc.toLowerCase("LovEly"));

    }
}
