import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Problem253 {

    public int minMeetingRooms(int[][] intervals) {

        Arrays.sort(intervals, (o1, o2) -> Integer.compare(o1[0], o2[0]));
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.offer(intervals[0][1]);

        for(int i = 1; i< intervals.length; i++) {
            int currentStartTime = intervals[i][0];
            int smallestEndTime = pq.peek();
            if(currentStartTime>=smallestEndTime) {
                pq.poll();
            }

            pq.offer(intervals[i][1]);
        }

        return pq.size();
    }
}
