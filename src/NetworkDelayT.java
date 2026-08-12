import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class NetworkDelayT {
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, List<int[]>> adjList = new HashMap<>();
        for(int[] time : times ){
            adjList.computeIfAbsent(time[0], x->new ArrayList<>()).add(new int[]{time[1],time[2]});
        }
        Map<Integer, Integer> distances = new HashMap<>();
        distances.put(k, 0);
        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        heap.offer(new int[]{0, k});
        while (!heap.isEmpty()) {
            int[] curr = heap.poll();
            int  dist = curr[0], node = curr[1];
            if (dist > distances.getOrDefault(node, Integer.MAX_VALUE))
                continue;
            for (int[] edge : adjList.getOrDefault(node, new ArrayList<>())) {
                int neighbor = edge[0], weight = edge[1];
                int newDist = dist + weight;
                if (newDist < distances.getOrDefault(neighbor, Integer.MAX_VALUE)) {
                    distances.put(neighbor, newDist);
                    heap.offer(new int[]{newDist, neighbor});
                }
            }

        }
        if (distances.size() != n) return -1;
        return Collections.max(distances.values());
    }
}
