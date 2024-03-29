package org.learn.leetcode.easy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MergedIntervals {
    public List<Interval> merge(List<Interval> intervals) {
        Collections.sort(intervals, new Comparator<Interval>() {

            public int compare(Interval i1, Interval i2) {
                return Integer.compare(i1.start, i2.start);
            }
        });

        List<Interval> result = new ArrayList<>();
        result.add(intervals.get(0));
        for (int i = 1; i < intervals.size(); i++) {

            Interval currentinterval = intervals.get(i);
            Interval prevInterval = intervals.get(i - 1);
            if (currentinterval.start <= prevInterval.end) {
                Interval mergedInterval = new Interval(prevInterval.start, prevInterval.end > currentinterval.end ? prevInterval.end : currentinterval.end);
                result.remove(i - 1);
                result.add(mergedInterval);
            } else {
                result.add(currentinterval);
            }
        }

        return result;
    }
}
