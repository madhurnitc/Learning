import java.util.Arrays;
import java.util.PriorityQueue;


public class MeetingRooms2 {
    public int minMeetingRooms(int[][] intervals) {
        if(intervals == null || intervals.length == 0){
            return 0;
        }

        Arrays.sort(intervals, (a,b)->a[0]-b[0]);
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.offer(intervals[0][1]);

        for(int i =1; i<intervals.length; i++) {
            if(pq.peek() <= intervals[1][0]){
                pq.poll();
            }
            pq.offer(intervals[i][1]);
        }
        
        return pq.size();
    }
}
