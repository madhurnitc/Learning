package org.learn.leetcode.easy;

import java.util.HashSet;
import java.util.Set;

public class HappyNumber {

    public boolean isHappy(int n) {

        Set<Integer> set = new HashSet<>();

        while (true) {

            int sum = 0;
            while (n != 0) {
                int r = n % 10;
                sum = sum + r * r;
                n = n / 10;
            }
            if (!set.contains(sum)) {
                set.add(sum);
            } else if (sum == 1) {
                return true;
            } else {
                return false;
            }

            n = sum;
        }
    }
}
