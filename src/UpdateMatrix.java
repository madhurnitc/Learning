import java.util.LinkedList;
import java.util.Queue;

public class UpdateMatrix {
    int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public int[][] updateMatrix(int[][] mat) {

        int rows = mat.length;
        int cols = mat[0].length;
        int[][] result = new int[rows][cols];
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if(mat[i][j] == 0) {
                    result[i][j] = 0;
                    queue.offer(new int[]{i, j});
                }else {
                    result[i][j] = -1;
                }
            }
        }
        int distance =1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] point = queue.poll();
                int row = point[0];
                int col = point[1];
                for (int[] direction : directions) {
                    int nextRow = row + direction[0];
                    int nextCol = col + direction[1];
                    if(nextRow>=0 && nextRow<rows && nextCol>=0 && nextCol<cols && result[nextRow][nextCol] == -1) {
                        queue.offer(new int[]{nextRow, nextCol});
                        result[nextRow][nextCol] = distance;
                    }
                }
            }
            distance++;
        }
        return result;
    }
}
