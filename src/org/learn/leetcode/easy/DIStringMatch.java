package org.learn.leetcode.easy;

public class DIStringMatch {

    public int[] diStringMatch(String S) {
        int N = S.length();
        int[] A = new int[N + 1];
        int l = 0;
        int h = N;

        for (int i = 0; i < N; i++) {
            if (S.charAt(i) == 'I') {
                A[i] = l;
                l++;
            } else if (S.charAt(i) == 'D') {
                A[i] = h;
                h--;
            }

            A[N] = l;
        }


        return A;


    }

    public static void main(String[] args) {

        DIStringMatch dism = new DIStringMatch();
        dism.diStringMatch("IDIDI");
    }
}
