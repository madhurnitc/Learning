import java.util.LinkedList;
import java.util.List;

public class Problem57 {

    public int[][] insert(int[][] intervals, int[] newInterval) {

        List<int[]> list = new LinkedList<>();
        int i  = 0;
        while( i< intervals.length && newInterval[0] > intervals[i][0]) {
            list.add(intervals[i++]);
        }

        if(!mergeRequired(list, newInterval)) {
            list.add(newInterval);
        }else {
            int[] lastInterval = list.get(list.size()-1);
            lastInterval[1] = Math.max(lastInterval[1], newInterval[1]);
        }

        performMerge(intervals, list, i);

        return list.toArray(new int[list.size()][2]);
    }

    private void performMerge(int[][] intervals, List<int[]> list, int i) {

        while(i < intervals.length) {
            int[] currentInterval = intervals[i];
            if(currentInterval[0] > list.get(list.size()-1)[1]) {
                list.add(currentInterval);
            }else {
                int[] lastInterval = list.get(list.size()-1);
                lastInterval[1] = Math.max(lastInterval[1], currentInterval[1]);
            }
        }
    }


    private boolean mergeRequired(List<int[]> list, int[] newInterval) {

        return (!list.isEmpty()) && list.get(list.size()-1)[1] >= newInterval[0];
    }
}
