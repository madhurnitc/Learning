import java.util.Arrays;

public class Problem435Sol2 {

    public int eraseOverlapIntervals(int[][] intervals) {


        Arrays.sort(intervals, (int[]a, int[] b)-> a[0]==b[0]?a[1]-b[1]:a[0]-b[0]);

        int ans = 0;
        int endTime = intervals[0][1];

        for(int i = 1; i<intervals.length; i++) {

            if (intervals[i][0] < endTime) {
                ans++;
                endTime = Math.min(endTime, intervals[i][1]);
            }else {
                endTime = intervals[i][1];
            }
        }

        return ans;
    }
}
