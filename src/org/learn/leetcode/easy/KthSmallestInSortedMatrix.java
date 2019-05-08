package org.learn.leetcode.easy;

import java.util.PriorityQueue;

public class KthSmallestInSortedMatrix {

    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Tuple> pq = new PriorityQueue<>();
        int n = matrix.length;
        for(int i = 0; i< matrix[0].length; i++){
            pq.offer(new Tuple(0,i,matrix[0][i]));
        }

        for(int j =0; j<n-1; j++) {
            Tuple min = pq.poll();
            if(min.x == n-1) {
                continue;
            }
            pq.offer(new Tuple(min.x+1, min.y, matrix[min.x+1][min.y]));
        }

        return pq.poll().val;
    }

    public class Tuple implements Comparable<Tuple> {

        int x;
        int y;
        int val;

        public Tuple(int x, int y, int val) {
            this.val = val;
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Tuple that) {
            return this.val - that.val;
        }
    }
}
