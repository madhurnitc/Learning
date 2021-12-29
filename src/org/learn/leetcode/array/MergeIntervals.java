package org.learn.leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {
    public int[][] merge(int[][] intervals) {

        if (intervals == null || intervals.length == 0) return intervals;
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[0], o2[0]);
            }
        });

        List<int[]> list = new ArrayList<>();
        list.add(intervals[0]);
        int j = 0;
        for(int i = 1 ; i<intervals.length; i++) {
           int currentStart = intervals[i][0];
           int currentEnd = intervals[i][1];
           int prevEnd = list.get(list.size()-1)[1];
           if(currentStart<= prevEnd) {
               int newEnd = prevEnd > currentEnd ? prevEnd : currentEnd;
               list.get(list.size()-1)[1] = newEnd;
           }else {
               list.add(intervals[i]);
           }

        }

        return list.toArray(new int[list.size()][]);
    }
}
