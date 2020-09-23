package org.learn.leetcode.easy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;

public class LargestNumber {

    private class CustomComparator implements Comparator<String> {

        @Override
        public int compare(String s1, String s2) {

            String v1 = s1 + s2;
            String v2 = s2 + s1;

            return v2.compareTo(v1);
        }
    }


    public String largestNumber(int[] nums) {
        String[] strArr = new String[nums.length];

        for (int i = 0; i < nums.length; i++) {
            strArr[i] = String.valueOf(nums[i]);
        }

        Arrays.sort(strArr, new CustomComparator());

        if (strArr[0].equals("0")) {
            return "0";
        }

        String largestNumber = "";

        for (String str : strArr) {
            largestNumber = largestNumber + str;
        }

        return largestNumber;
    }
}
