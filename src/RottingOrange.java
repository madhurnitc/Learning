import java.util.LinkedList;
import java.util.Queue;

public class RottingOrange {
    int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public Integer rotting_oranges(Character[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[rows][cols];
        int totalRotten = 0;
        int freshOranges = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 'R') {
                    totalRotten++;
                    queue.offer(new int[]{i, j});
                }else if (grid[i][j] == 'F') {
                    freshOranges++;
                }
            }
        }
        int totalMinutes =0;

        while (!queue.isEmpty() && freshOranges > 0) {
            totalMinutes++;
            Integer size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] point = queue.poll();
                int row = point[0];
                int col = point[1];
                for (int[] direction : directions) {
                    int nextRow = row + direction[0];
                    int nextCol = col + direction[1];
                    if (nextCol >= 0 && nextCol < cols && nextRow >= 0 && nextRow < rows && grid[nextRow][nextCol] == 'F') {
                        grid[nextRow][nextCol] = 'R';
                        freshOranges--;
                        queue.offer(new int[]{nextRow, nextCol});
                    }
                }

            }

        }
        return freshOranges==0?totalMinutes:-1;
    }
}
