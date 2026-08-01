import java.util.*;

public class PacificAtlanticWaterFlow {
    private static final int[][] DIRECTIONS = new int[][]{{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
    public List<List<Integer>> pacific_atlantic_flow(int[][] grid) {
        if(grid.length ==0 || grid[0].length == 0) {
            new ArrayList<>();
        }

        List<List<Integer>> result = new ArrayList<>();
        int[][] landHeights = grid;
        int rows = grid.length;
        int cols = grid[0].length;
        Queue<int[]> pq = new ArrayDeque<>();
        Queue<int[]> aq = new ArrayDeque<>();

        for(int i =0; i< cols; i++) {
            pq.offer(new int[]{0, i});
            aq.offer(new int[]{rows-1, i});
        }

        for(int i =0; i< rows; i++) {
            pq.offer(new int[]{i, 0});
            aq.offer(new int[]{i, cols-1});
        }

        boolean[][] prq = dfs(grid, pq, rows, cols);
        boolean[][] arq = dfs(grid, aq, rows, cols);

        for(int i =0; i<rows; i++) {
            for(int j =0; j<cols; j++) {
                if(prq[i][j] && arq[i][j]){
                    result.add(List.of(i, j));
                }
            }
        }

        return result;
    }

    private boolean[][] dfs(int[][] grid, Queue<int[]> q, int rows, int cols) {

        boolean[][] canflow = new boolean[rows][cols];
        while(!q.isEmpty()) {
            int[] cell = q.poll();
            canflow[cell[0]][cell[1]] = true;
            for(int[] dir: DIRECTIONS) {
                int newr = cell[0] +dir[0];
                int newc = cell[1] + dir[1];
                if(newr>=0 && newr<rows && newc >=0 && newc < cols && grid[newr][newc]>=grid[cell[0]][cell[1]]){
                    q.offer(new int[]{newr, newc});
                }
            }
        }
        return canflow;
    }
}
