import java.util.Arrays;
import java.util.Comparator;

public class Problem225 {
    public boolean canAttendMeetings(int[][] intervals) {

        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        for(int i =0; i<intervals[0].length-1;i++){

            if(intervals[i+1][0]<intervals[i][1]){
                return false;
            }
        }

        return true;
    }

}


