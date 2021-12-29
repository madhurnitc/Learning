import java.util.Arrays;

public class Problem452 {

    public int findMinArrowShots(int[][] points) {

        Arrays.sort(points, (int[] a, int[]b) -> a[0]-b[0]);

        int numOfArrows = 1;

        int end = points[0][1];

        for(int[] point : points) {
            int currentStart = point[0];
            int currentEnd = point[1];
            if(currentStart > end) {
                numOfArrows++;
                end = currentEnd;
            }else {
                end = Math.max(end, currentEnd);
            }

        }

        return numOfArrows;

    }

    public static void main(String[] args) {
        int[][] points = {
                {10,16},
                {2,8},
                {1,6},
                {7, 12}
        };

        new Problem452().findMinArrowShots(points);
    }
}
