package org.learn.leetcode.heap;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KthSmallestInSortedMatrix {

    public int kthSmallest(int[][] matrix, int k) {
        int r = matrix.length;
        int c = matrix[0].length;

        PriorityQueue<Tuple> pq = new PriorityQueue<Tuple>(new Comparator<Tuple>() {
            @Override
            public int compare(Tuple o1, Tuple o2) {
                return Integer.compare(o1.val, o2.val);
            }
        });

        for(int i = 0; i < r ; i++) {
            pq.offer(new Tuple(i,0, matrix[i][0]));
        }

        for(int i =0 ; i<k-1; k++) {
            Tuple min = pq.poll();
            if(min.y == c-1) {
                continue;
            }
            pq.offer(new Tuple(min.x, min.y+1, matrix[min.x][min.y+1]));
        }

        return pq.poll().val;
    }

    public static void main(String[] args) {
        int[][] matrix = { {1,5,9,},
                {10,11,13},
                {12,13,15}};
        new KthSmallestInSortedMatrix().kthSmallest(matrix, 8);
    }


    class Tuple  {
        int x, y, val;

        public Tuple(int x, int y, int val) {
            this.x = x;
            this.y = y;
            this.val = val;
        }

    }
}




