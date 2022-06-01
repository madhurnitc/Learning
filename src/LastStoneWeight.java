import java.util.PriorityQueue;
import java.util.Stack;

public class LastStoneWeight {

    public int lastStoneWeight(int[] stones) {

        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b-a);
        for(int stone : stones) {

            pq.offer(stone);
        }

        while(pq.size() >1 ) {
            int stone1 = pq.remove();
            int stone2 = pq.remove();
            if(stone1 != stone2) {
                pq.offer(stone1-stone2);
            }
        }

        return pq.isEmpty() ? 0: pq.peek();
    }
}
