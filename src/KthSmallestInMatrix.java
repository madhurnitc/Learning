import java.util.PriorityQueue;

public class KthSmallestInMatrix {

    public int kthSmallest(int[][] matrix, int k) {

        PriorityQueue<Tuple> pq = new PriorityQueue<>((o1, o2) -> o1.val-o2.val);

        int rowCount = matrix.length;
        int colCount = matrix[0].length;

        for (int i = 0; i<rowCount; i++) {

            pq.offer(new Tuple(i, 0, matrix[i][0]));
        }

        for(int i = 0 ; i< k-1; i++) {

            Tuple min = pq.poll();
            if(min.y == colCount-1) { // we have reached the end of the list at that row
                continue;
            }

            pq.offer(new Tuple(min.x, min.y+1, matrix[min.x][min.y+1]));
        }

        return pq.poll().val;
    }


    public class Tuple {

        int x;
        int y;
        int val;

        public Tuple(int x, int y, int val) {

            this.x = x;
            this.y = y;
            this.val = val;

        }
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1,5,9},{10,11,13},{12,13,15}};

        System.out.println(new KthSmallestInMatrix().kthSmallest(matrix, 8));
    }
}
