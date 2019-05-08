package org.learn.leetcode.easy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MinimumMeetingRoomsWith2DArrayAsInput {
    public int minMeetingRooms(int[][] intervals) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(intervals.length, new Comparator<Integer>(){

            public int compare(Integer e1, Integer e2) {
                return Integer.compare(e1, e2);
            }
        });

        Arrays.sort(intervals, new Comparator<int[]>(){

            public int compare(int[] i1, int[] i2) {

                return i1[0]-i2[0];
            }
        });

        pq.offer(intervals[0][1]);
        for(int i = 1; i< intervals.length; i++) {

            if(intervals[i][0] >= pq.peek()) {
                pq.poll();
            }

            pq.offer(intervals[i][1]);
        }

        return pq.size();
    }
}
