package org.learn.leetcode.easy;

public class SortArrayByParity {
    public int[] sortArrayByParity(int[] A) {

        int i = 0;
        int j = A.length - 1;
        while (i < j) {
            if (A[i] % 2 > A[j] % 2) {
                swap(A, i, j);
            }

            if (A[i] % 2 == 0) {
                i++;
            }
            if (A[j] % 2 != 0) {
                j--;
            }
        }

        return A;
    }

    private void swap(int[] A, int i, int j) {

        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }

    public static void main(String[] args) {
        SortArrayByParity sortArrayByParity = new SortArrayByParity();

        System.out.println(sortArrayByParity.sortArrayByParity(new int[]{3, 1, 2, 4}));
    }
}
