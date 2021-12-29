package org.learn.leetcode.amazon;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MeetingRooms2 {

    public int minMeetingRooms(int[][] intervals) {

        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[0], o2[0]);
            }
        });

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.offer(intervals[0][1]);

        for (int i = 1 ; i < intervals.length; i++) {
            int curStartTime = intervals[i][0];
            int endtime = pq.peek();
            if(curStartTime>= endtime) {
                pq.poll();
            }
            pq.offer(intervals[i][1]);
        }

        return pq.size();
    }
}
