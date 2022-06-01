import java.util.*;

public class Problem365 {

    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {

        List<List<Integer> > result = new ArrayList<>();

        if(nums1.length == 0 || nums2.length == 0 || k ==0) {
            return result;
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) ->  nums1[a[0]]+ nums2[a[1]] -(nums1[b[0]]+nums2[b[1]]));
        for(int i = 0; i<nums1.length && i<k ; i++){
            pq.offer(new int[] {i, 0});
        }

        while( k>0 && !pq.isEmpty()) {

            int[]cur = pq.poll();
            result.add(new ArrayList<>(Arrays.asList(cur[0], cur[1])));
            if(cur[1]== nums2.length-1) continue;
            pq.offer(new int[]{ cur[0], cur[1]+1 });
            k--;
        }

        return result;
    }
}
