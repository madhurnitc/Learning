package com.twentysix.leetcode;

import java.util.ArrayList;
import java.util.List;

public class InsertInterval {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        if(intervals == null || intervals.length ==0) {
            return new int[][]{newInterval};
        }
        int i =0;

        List<int[]> result = new ArrayList<>();

        while (i<intervals.length && intervals[i][1] < newInterval[0]){
            result.add(intervals[i]);
            i++;
        }

        while(i<intervals.length && intervals[i][0]<=newInterval[1]){
            newInterval[0] = Math.min(intervals[i][0], newInterval[0]);
            newInterval[1] = Math.max(intervals[i][1], newInterval[1]);
            i++;
        }
        
        result.add(newInterval);

        while(i<intervals.length){
            result.add(intervals[i++]);
        }

        return result.toArray(new int[result.size()][]);
    }
}
