import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {

    public int[][] merge(int[][] intervals) {

        Arrays.sort(intervals,(o1, o2) -> {

            return o1[0]-o2[0];
        });

        List<int[]> resultList = new ArrayList<>();
        resultList.add(intervals[0]);

        for(int i = 1; i< intervals.length; i++) {
            int prevEnd = resultList.get(resultList.size()-1)[1];
            int currStart = intervals[i][0];
            int currEnd = intervals[i][1];
            if(currStart<= prevEnd) {
                int newEndTime = Math.max(currEnd, prevEnd);
                resultList.get(resultList.size()-1)[1] = newEndTime;
            }else {
                resultList.add(intervals[i]);
            }
        }

        return resultList.toArray(new int[resultList.size()][]);
    }
}
