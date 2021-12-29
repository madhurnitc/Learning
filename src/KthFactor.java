import java.util.PriorityQueue;

public class KthFactor {

    public int kthFactor(int n, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b-a);
        int sqRoot = (int) Math.sqrt(n);
        for(int i = 1; i <= sqRoot; i++) {
            if( n%i == 0) {
                offer(pq,i, k);
                if( i != n/i) {
                    offer(pq,n/i, k);
                }
            }
        }

        return pq.size() == k ? pq.peek() : -1;

    }
    public void offer(PriorityQueue<Integer> pq, int i, int size) {
        pq.offer(i);
        if(pq.size() > size) {
            pq.remove();
        }
    }

    public static void main(String[] args) {
        new KthFactor().kthFactor(12, 3);
    }
}
