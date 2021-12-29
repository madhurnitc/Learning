import java.util.Arrays;

public class Problem435 {

    public int eraseOverlapIntervals(int[][] intervals) {

        Arrays.sort(intervals, (int[] a, int[] b) -> a[0]-b[0]);

        int[] dp = new int[intervals.length];
        int ans = 1;
        for (int i = 0 ; i < intervals.length ; i++) {
            int max = 0;
            for (int j = i-1; j>=0; j--) {
                if(!isOverlapping(intervals[i], intervals[j])) {
                    max = Math.max(max, dp[j]);
                }
            }
            dp[i] = max+1;
            ans = Math.max(ans, dp[i]);

        }

        return intervals.length-ans;

    }


    private boolean isOverlapping(int[] current, int[] prev) {


        return current[0] < prev[1];
    }

    public static void main(String[] args) {
        int[][] intervals = {
                {1,2},
                {2,3},
                {3,4},
                {1,3}
        };

        new Problem435().eraseOverlapIntervals(intervals);
    }
}
