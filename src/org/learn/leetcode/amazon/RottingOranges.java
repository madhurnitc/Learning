package org.learn.leetcode.amazon;

import java.util.LinkedList;
import java.util.Queue;

public class RottingOranges {
    public int orangesRotting(int[][] grid) {
        int rcount = grid.length;
        int ccount = grid[0].length;
        int freshOranges = 0;
        int minutesElapsed = -1;
        int[][] directions = { {-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        Queue<int[]> queue = new LinkedList<>();
        for(int i = 0; i< rcount; i++) {
            for(int j = 0; j< ccount; j++) {
                if(grid[i][j] == 2) {

                    queue.offer(new int[] { i, j});

                } else if (grid[i][j] == 1) {
                    freshOranges++;
                }
            }
        }

        if(freshOranges == 0) {
            return 0;
        }
        while(!queue.isEmpty()) {

            int size = queue.size();
            minutesElapsed++;
            for (int i  = 0; i<size ; i++) {
                int[] cell = queue.poll();

                grid[cell[0]][cell[1]] = 0;
                for(int[] direction : directions) {

                    int neighborRow = cell[0] + direction[0];
                    int neighborCol = cell[1] + direction[1];
                    if(neighborRow >=0 && neighborRow <rcount && neighborCol >=0 && neighborCol <ccount) {
                        if(grid[neighborRow][neighborCol] == 1) {
                            freshOranges--;
                            grid[neighborRow][neighborCol] = 2;
                            queue.offer(new int[] {neighborRow, neighborCol});
                        }
                    }
                }
            }

        }

        return freshOranges == 0 ? minutesElapsed: -1;
    }


    public static void main(String[] args) {
        int[][] grid = new int[][] {
                {2,2,2,1,1}
        };

        System.out.println( new RottingOranges().orangesRotting(grid));
    }

}
