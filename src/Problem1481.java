import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Problem1481 {

    public int findLeastNumOfUniqueInts(int[] arr, int k) {

        Map<Integer, Integer> freqMap = new HashMap<>();
        for(int num : arr) {

            freqMap.put(num, freqMap.getOrDefault(num, 0) +1);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.comparing(freqMap::get));
        for(Integer key : freqMap.keySet()) {
            pq.offer(key);
        }

        while (k >0 && !pq.isEmpty()) {
            k -= freqMap.get(pq.poll());
        }


        return k <0 ? pq.size()+1 : pq.size();
    }

    public static void main(String[] args) {
        int[] arr = {4,3,1,1,3,3,2,2};
        new Problem1481().findLeastNumOfUniqueInts(arr, 3);
    }
}
