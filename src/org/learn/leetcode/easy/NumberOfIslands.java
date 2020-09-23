package org.learn.leetcode.easy;

public class NumberOfIslands {

    public int numIslands(char[][] grid) {

        if (grid == null || grid.length == 0) {
            return 0;
        }

        int r = grid.length;
        int c = grid[0].length;
        int numIslands = 0;
        for (int i = 0; i < r; ++i) {
            for (int j = 0; j < c; ++j) {

                if (grid[i][j] == '1') {
                    numIslands++;
                    grid[i][j] = '0';
                    dfs(grid, i, j);
                }
            }
        }

        return numIslands;
    }


    private void dfs(char[][] grid, int r, int c) {


        if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length) {
            return;
        }

        grid[r][c] = '0';

        dfs(grid, r, c + 1);
        dfs(grid, r, c - 1);
        dfs(grid, r - 1, c);
        dfs(grid, r + 1, c);
    }
}
