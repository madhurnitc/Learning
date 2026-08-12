import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class CheapestFlightWithAtmostKStops {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        Map<Integer, List<int[]>> adjList = new HashMap<>();
        for (int[] f : flights) {
            adjList.computeIfAbsent(f[0], k -> new ArrayList<>()).add(new int[]{f[1], f[2]});
        }
        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        heap.offer(new int[]{0, src, 0});

        Map<String, Integer> best = new HashMap<>();
        while(!heap.isEmpty()){
            int[] curr = heap.poll();
            int cost = curr[0], city = curr[1], stops = curr[2];
            if(city == dst) {
                return cost;
            }
            if(stops>k) continue;
            String key = city + "," + stops;
            if (best.containsKey(key) && best.get(key) <= cost) continue;
            best.put(key, cost);
            for (int[] next : adjList.getOrDefault(city, new ArrayList<>())) {
                int newCost = cost + next[1];
                heap.offer(new int[]{newCost, next[0], stops + 1});
            }
        }
        return -1;
    }
}
