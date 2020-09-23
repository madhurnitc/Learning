package org.learn.leetcode.easy;

public class SquareRoot {

    public int mySqrt(int x) {

        if (x == 0) return 0;
        if (x == 1) return 1;

        int ans = 0;

        int lo = 1;
        int hi = x;
        while (lo <= hi) {

            int mid = lo + (hi - lo) / 2;
            if (mid == x / mid) {
                return mid;
            } else if (mid < x / mid) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }

        return ans;
    }

    public static void main(String[] args) {

        new SquareRoot().mySqrt(8);
    }
}
