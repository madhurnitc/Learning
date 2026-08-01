import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class KnightMoves {

    public Integer minimumKnightMoves(Integer x, Integer y) {
        int[][] directions = {{2, 1}, {2, -1}, {-2, 1}, {-2, -1},
                {1, 2}, {1, -2}, {-1, 2}, {-1, -2}};

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0, 0});
        Set<String> visited = new HashSet<>();
        visited.add("0,0");
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] cur = queue.poll();
                int row = cur[0];
                int col = cur[1];
                int moves = cur[2];
                if (row == x  && col == y ) {
                    return moves;
                }

                for (int[] d : directions) {
                    int nx = cur[0] + d[0];
                    int ny = cur[1] + d[1];
                    String key = nx + "," + ny;
                    if(!visited.contains(key)) {
                        queue.offer(new int[]{nx, ny, moves + 1});
                    }

                }
            }
        }
        return -1;
    }
}
