package org.learn.leetcode.easy;

public class PrimeNumbers {

    public int countPrimes(int n) {
        boolean[] prime = new boolean[n + 1];
        int count = 0;
        for (int i = 0; i < n + 1; i++) {
            prime[i] = true;
        }

        for (int p = 2; p * p < n; p++) {

            if (prime[p] == true) {
                count++;
                for (int i = p * p; i <= n; i = i + p) {
                    prime[i] = false;
                }
            }
        }


        return count;

    }

    public static void main(String[] args) {
        new PrimeNumbers().countPrimes(10);
    }
}
