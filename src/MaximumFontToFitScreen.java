import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class MaximumFontToFitScreen {

    public int[] kWeakestRows(int[][] mat, int k) {

        Map<Integer,RowInfo> rowToSoldierCount = new HashMap<>();
        PriorityQueue<RowInfo> pq = new PriorityQueue<>((a,b) -> {
            return a.sCount-b.sCount;
        });

        int[] result = new int[k];
        int r = 0;
        for(int[] row : mat) {
            int count = 0;
            for(int i = 0; i<row.length ;i++){
                if(row[i] == 1) {
                    count++;
                }
            }
            rowToSoldierCount.put(r, new RowInfo(r, count));
        }

        for(Map.Entry<Integer, RowInfo> entry : rowToSoldierCount.entrySet()) {

            pq.offer(entry.getValue());

        }
        int i = 0;
        while (k>0) {
            result[i++] = pq.poll().rNumber;
            k--;
        }

        return result;
    }

    public class RowInfo {
        int rNumber;
        int sCount;

        public RowInfo(int row, int count) {
            rNumber = row;
            sCount = count;
        }
    }
}
