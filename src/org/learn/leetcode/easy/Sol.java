package org.learn.leetcode.easy;

public class Sol {

    static boolean isValid(String unencrypted, String encrypted) {


        int min = 0;
        for (int i = 0; i < unencrypted.length(); i++) {

            int index = encrypted.indexOf(unencrypted.charAt(i));
            if (index < min) {
                return false;
            }

            min = index;

        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(Sol.isValid("SECRET", "SOMECORESAREINDEPENDENT"));
    }
}
