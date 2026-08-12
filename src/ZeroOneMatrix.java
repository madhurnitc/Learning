import java.util.LinkedList;
import java.util.Queue;

public class ZeroOneMatrix {

    public int[][] updateMatrix(int[][] mat) {
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        int rows= mat.length-1;
        int cols= mat[0].length-1;
        int[][] result = new int[mat.length][mat[0].length];
        Queue<int[]> queue = new LinkedList<>();
        for(int i =0; i<=rows; i++){
            for(int j =0; j<=cols; j++){
                if(mat[i][j] == 0){
                    result[i][j] = 0;
                    queue.offer(new int[]{i,j});
                }else{
                    result[i][j] = -1;
                }
            }
        }
        int distance = 1;
        while(!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] cell = queue.poll();
                int row = cell[0];
                int col = cell[1];
                for(int[] dir : directions) {
                    int nr = row+dir[0];
                    int nc = col+dir[1];
                    if(nr>=0 && nr<=rows && nc>=0 && nc<=cols){
                        if(result[nr][nc] == -1) {
                            result[nr][nc] = distance;
                            queue.offer(new int[]{nr, nc});
                        }
                    }
                }
            }
            distance++;
        }
        return result;
    }

    public static void main(String[] args) {
        ZeroOneMatrix solution = new ZeroOneMatrix();
        int[][] mat = {{0, 0, 0}, {0, 1, 0}, {1, 1, 1}};
        int[][] result = solution.updateMatrix(mat);
        for (int[] row : result) {
            System.out.println(java.util.Arrays.toString(row));
        }
    }
}
