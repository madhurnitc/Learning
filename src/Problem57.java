import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Problem57 {

    public int[][] insert(int[][] intervals, int[] newInterval) {
        int i = 0;
        List<int[]> result = new ArrayList<>();
        while(i < intervals.length && intervals[i][1]< newInterval[0]) {
            result.add(intervals[i]);
            i++;
        }

        while(i < intervals.length && intervals[i][0] <= newInterval[1]){
            newInterval = new int[] { Math.min(intervals[i][0], newInterval[0]),
                    Math.max(intervals[i][1], newInterval[1])};
            i++;
        }

        result.add(newInterval);
        while(i < intervals.length) {
            result.add(intervals[i]);
            i++;
        }

        return result.toArray(new int[result.size()][2]);
    }


    public static void main(String[] args) {

        int[][] intervals = {{1,2},{3,5},{6,7},{8,10},{12,16}};
        int[] newInterval = {4,8};
        System.out.println(new Problem57().insert(intervals, newInterval));
    }
}
