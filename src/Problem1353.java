import java.util.Arrays;
import java.util.PriorityQueue;

public class Problem1353 {
    public int maxEvents(int[][] events) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        Arrays.sort(events, (a,b) -> a[0]-b[0]);
        int numOfDays = 100000;
        int i =0;
        int result =0;
        for(int d = 1; d <= numOfDays; d++) {

            while(!pq.isEmpty() && pq.peek() <d) {
                pq.poll();
            }
            while(i< events.length && events[i][0] == d){
                pq.offer(events[i][1]);
                i++;
            }

            if(!pq.isEmpty()) {
                pq.poll();
                result++;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[][] events = {
                {1,2},
                {2,3},
                {3,4},
                {1,2}
        };

        new Problem1353().maxEvents(events);
    }
}
