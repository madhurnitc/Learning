package org.learn.leetcode.easy;

import java.util.*;

public class MergedIntervalWithArrayInputs {

    public int[][] merge(int[][] intervals) {

        if (intervals == null || intervals.length == 0 ) return intervals;

        Collections.sort(Arrays.asList(intervals), new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[0], o2[0]);
            }
        });

        List<int[]> merged = new ArrayList<>();

        merged.add(intervals[0]);

        for(int i =1 ; i<intervals.length ;i++) {
            int currStart = intervals[i][0];
            int prevEnd = merged.get(merged.size()-1)[1];

            if (currStart <= prevEnd) {
                int newEnd = intervals[i][1] > prevEnd ? intervals[i][1] : prevEnd;
                merged.get(merged.size()-1)[1] = newEnd;
            }else {
                merged.add(intervals[i]);
            }
        }

        return merged.toArray(new int[merged.size()][]);
    }

    public static void main(String[] args) {

        //int[][] input = {{1,3},{2,6},{8,10},{15,18}};
        //int[][] input = {};
        int[][] input = {{1,4},{0,2},{3,5}};
        new MergedIntervalWithArrayInputs().merge(input);
    }
}
