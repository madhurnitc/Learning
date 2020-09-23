package org.learn.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

public class Sol4 {

    public static List<Integer> getMinimumUniqueSum(List<String> arr) {
        // Write your code here

        List<Integer> result = new ArrayList<>();
        for (String input : arr) {

            String[] splittedInput = input.split(" ");
            int a = Integer.parseInt(splittedInput[0]);
            int b = Integer.parseInt(splittedInput[1]);
            Double count = findPerfectSqaures(a, b);
            result.add(count.intValue());
        }

        return result;

    }

    private static double findPerfectSqaures(int a, int b) {

        return (Math.floor(Math.sqrt(b))-Math.ceil(Math.sqrt(a))+1);

    }
}
