package org.learn.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

public class SelfDivdingNumbers {

    public List<Integer> selfDividingNumbers(int left, int right) {

        List<Integer> result = new ArrayList<>();

        for (int i = left; i <= right; i++) {

            int d = 10;
            int number = i;
            while (number != 0) {
                int q = number / 10;
                int r = number % 10;
                if (r != 0 && number % r != 0) {
                    break;
                } else if (r == 0) {
                    break;
                } else {
                    number = q;
                    result.add(number);
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {

        SelfDivdingNumbers selfDivdingNumbers = new SelfDivdingNumbers();
        selfDivdingNumbers.selfDividingNumbers(1, 22);
    }
}
