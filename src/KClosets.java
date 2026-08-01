import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class KClosets {

    public List<Integer> kClosest(int[] nums, Integer k, Integer target) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->b[0]-a[0]);

        for(int i=0;i<nums.length;i++){
            int distance = Math.abs(nums[i]-target);
            if(pq.size() <k) {
                pq.offer(new int[]{distance, nums[i]});
            }else {
                int farthest = pq.peek()[0];
                if(distance < farthest) {
                    pq.poll();
                    pq.offer(new int[]{distance, nums[i]});
                }

            }

        }

        List<Integer> distances = new ArrayList<>();
        for(int[] pair : pq) {
            distances.add(pair[1]);
        }
        Collections.sort( distances);
        return distances;
    }
}
