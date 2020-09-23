package org.learn.leetcode.easy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MinimumMeetingRoom {
    public int minMeetingRooms(Interval[] intervals) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(intervals.length, new Comparator<Integer>() {

            public int compare(Integer a, Integer b) {
                return a.compareTo(b);
            }
        });

        Arrays.sort(intervals, new Comparator<Interval>() {

            public int compare(Interval i1, Interval i2) {
                return Integer.compare(i1.start, i2.start);
            }
        });

        pq.offer(intervals[0].end);

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i].start > pq.peek()) {
                pq.poll();
            }

            pq.offer(intervals[i].end);
        }

        return pq.size();
    }
}
