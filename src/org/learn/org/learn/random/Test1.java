package org.learn.org.learn.random;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Test1 {

    public  int minDays(int rows, int col, List<List<Integer>> grid) {

        if (grid == null) return -1;
        if (rows == 0 || col== 0) return -1;

        Queue<int[]> queue = new LinkedList<>();
        int target = rows*col;
        int cnt = 0, res = 0;


        for(int i=0;i<grid.size();i++) {
            for(int j=0;j<grid.get(i).size();j++) {
                if(grid.get(i).get(j) == 1) {
                    queue.offer(new int[] {i,j});
                    cnt++;
                }
            }
        }
        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        while(!queue.isEmpty()) {
            int size = queue.size();
            if(cnt == target)
                return res;
            for(int i=0;i<size;i++) {
                int[] cur = queue.poll();
                for(int[] dir : dirs) {
                    int ni = cur[0] + dir[0];
                    int nj = cur[1] + dir[1];
                    if(ni >=0 && ni < rows && nj >=0 && nj < col && grid.get(ni).get(nj) == 0) {
                        cnt++;
                        queue.offer(new int[] {ni, nj});
                        grid.get(ni).set(nj, 1);
                    }
                }
            }
            res++;
        }
        return -1;
    }
}
