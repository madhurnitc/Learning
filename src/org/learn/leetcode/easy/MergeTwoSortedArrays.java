package org.learn.leetcode.easy;

public class MergeTwoSortedArrays {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int t1 = m-1, t2 = n-1, finalPos = m+n-1;

        while(t1>=0 && t2>=0) {
            nums1[finalPos--] = (nums1[t1] > nums2[t2]) ? nums1[t1--] : nums2[t2--];
        }

        while(t2>=0) {
            nums1[finalPos++] = nums2[t2--];
        }

    }

    public static void main (String[] args) {

        MergeTwoSortedArrays ms = new MergeTwoSortedArrays();

        int [] a1 = new int[] {1};
        int []a2 = new int [] {2};
        int m = 1, n=0;

        ms.merge(a1,m,a2,n);

    }
}
