import java.util.Comparator;
import java.util.PriorityQueue;

public class KClosetsPointsToOrigin {    public int[][] kClosest(int[][] points, int k) {
        if(points == null || points.length == 0) {
            return new int[][]{};
        }
        PriorityQueue<long[]> pq = new PriorityQueue<>(new Comparator<long[]>() {
            @Override
            public int compare(long[] p1, long[] p2){
                return Long.compare(p2[0], p1[0]);
            }
        });
        int i = 0;
        for(int[] point : points) {
            long d = distance(point);
            if(pq.size() == k) {
                if(pq.peek()[0] > d) {
                    pq.poll();
                    pq.offer(new long[]{d, i});
                }
            }else {
                pq.offer(new long[]{d, i});
            }
            i++;
        }
        i=0;
        int[][] result = new int[k][2];
        while(k>0){
            result[i] = points[(int)pq.poll()[1]];
            k--;
        }

        return result;
    }

    private long distance(int[] point) {
        return 1L*point[0]*point[0] + 1L*point[1]*point[1];
    }
    public static void main(String[] args) {
        int[][] points = new int[][]{{3,3},{5,-1},{-2,4}};
        int k = 2;
        KClosetsPointsToOrigin kClosetsPointsToOrigin = new KClosetsPointsToOrigin();
        int[][] result = kClosetsPointsToOrigin.kClosest(points, k);
        for(int i = 0; i<result.length; i++) {
            System.out.println(result[i][0] + " " + result[i][1]);
        }
    }
}
