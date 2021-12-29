package org.learn.leetcode.amazon;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KClosestsPointsFromOrigin {

    public int[][] kClosest(int[][] points, int K) {

        PriorityQueue<Record> pq = new PriorityQueue<>(new Comparator<Record>() {
            @Override
            public int compare(Record o1, Record o2) {
                return Double.compare(o1.distance, o2.distance);
            }
        });

        for(int i = 0; i< points.length; i++) {
            int[] point = points[i];
            double distance = Math.sqrt(Math.pow(point[0], 2) + Math.pow(point[1],2));
            Record record = new Record(point, distance);
            pq.offer(record);
        }
        int[][] ans = new int[K][];
        int j = 0;
        while(K>0) {
            ans[j] = pq.poll().points;
            j++;
            K--;
        }

        return ans;
    }

    public class Record {
        int[] points;
        double distance;
        public Record (int[] points, double distance) {

            this.points = points;
            this.distance = distance;
        }
    }
}
