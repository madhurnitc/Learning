import java.util.ArrayList;
import java.util.List;

public class InsertInterval {

    public int[][] insert(int[][] intervals, int[] newInterval) {

        if(intervals.length == 0){
            return new int[][]{newInterval};
        }

        int index = findInsertPosition(intervals, newInterval[0]);
        List<int[]> result = new ArrayList<>();
        addIntervals(intervals, 0, index, result);
        result.add(newInterval);
        addIntervals(intervals, index, intervals.length, result);

        List<int[]> mergedIntervals = mergeIntervals(result);

        return mergedIntervals.toArray(new int[mergedIntervals.size()][2]);

    }

    private int findInsertPosition(int[][] intervals, int start) {

        int lo = 0;
        int hi = intervals.length-1;

        while (lo <= hi) {
            int mid = lo + (hi-lo)/2;
            if(intervals[mid][0] == start) {
                return mid;
            }else if (intervals[mid][0] < start){
                lo++;
            }else {
                hi--;
            }
        }

        return lo;
    }

    private void addIntervals(int[][] intervals, int start, int end, List<int[]> result) {
        for (int i = start; i<end; i++) {
            result.add(intervals[i]);
        }


    }

    private List<int[]> mergeIntervals(List<int[]> intervals) {
        List<int[]> result = new ArrayList<>();

        for(int[] interval : intervals){

            if(result.isEmpty() || result.get(result.size()-1)[1] < interval[0]){
                result.add(interval);
            }else {
                result.get(result.size()-1)[1] = Math.max(result.get(result.size()-1)[1], interval[1]);
            }

        }

        return result;

    }

    public static void main(String[] args) {
        InsertInterval i = new InsertInterval();
        i.insert(new int[][]{{1,2},{3,5},{6,7},{8,10},{12,16}}, new int[]{4,8});
    }

}
