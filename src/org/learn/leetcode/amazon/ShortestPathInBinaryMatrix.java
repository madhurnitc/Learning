package org.learn.leetcode.amazon;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ShortestPathInBinaryMatrix {

    private static final int[][] directions =
            new int[][]{{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};
    public int shortestPathBinaryMatrix(int[][] grid) {

        int  r = grid.length;
        int c = grid[0].length;

        if (grid[0][0] != 0 || grid[r-1][c-1] != 0) {
            return -1;
        }

        Queue<int[]> queue = new LinkedList<>();
        grid[0][0] = 1;
        queue.offer(new int[] {0,0});

        while(! queue.isEmpty()) {


            int[] cell = queue.poll();
            int row = cell[0];
            int col = cell[1];
            int distance = grid[row][col];
            if (row == grid.length - 1 && col == grid[0].length - 1) {
                return distance;
            }

            for (int[] validNeighbor : getValidNeigbors(row, col, grid)) {
                int nrow = validNeighbor[0];
                int ncol = validNeighbor[1];
                queue.offer(new int[]{nrow, ncol});
                grid[nrow][ncol] = distance + 1;
            }
        }

        return -1;

    }

    private List<int[]> getValidNeigbors(int row, int col, int[][] grid) {
        List<int[]> validNeighbors = new ArrayList<>();
        for(int[] direction : directions) {
            int newRow = row + direction[0];
            int newCol = col + direction[1];

            if (newRow < 0 || newRow >= grid.length || newCol <0 || newCol >= grid[0].length || grid[newRow][newCol] != 0) {
                continue;
            }
            validNeighbors.add(new int[] { newRow, newCol});

        }

        return validNeighbors;
    }

    public static void main(String[] args) {
        int[][] grid = {{0,0,0},
                {1,1,0},
                {1,1,0}};

        new ShortestPathInBinaryMatrix().shortestPathBinaryMatrix(grid);
    }

}
