public class NumberOfIslands {
    private static final int[][] dirs = {{0,1}, {0,-1},{1,0}, {-1,0}};
    public Integer number_of_islands(int[][] grid) {
        if(grid.length ==0) {
            return 0;
        }
        int number_of_islands = 0;

        for(int i =0; i< grid.length; i++){
            for(int j =0; j<grid[0].length; j++) {
                if(grid[i][j] == 1) {
                    number_of_islands++;
                    dfs(grid, i, j);
                }
            }
        }

        return number_of_islands;
    }

    private void dfs(int[][] grid, int r, int c) {
        if(r <0 || r>=grid.length || c<0 || c>=grid[0].length|| grid[r][c] ==0 ) {
            return;
        }
        grid[r][c] = 0;
        for(int[] dir : dirs) {
            dfs(grid, r+dir[0], c+dir[1]);
        }
    }
}
