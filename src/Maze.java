public class Maze {

    boolean[][] visited ;
    int[][] dirs = new int[][] {{0,1}, {0,-1},{-1,0}, {1,0}};

    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        visited = new boolean[maze.length][maze[0].length];
        return hasPaths(maze, start[0], start[1], destination);

    }

    private boolean hasPaths(int[][] maze, int row, int column, int[] destination) {

        if(visited[row][column]) {
            return false;
        }

        if(row == destination[0] && column == destination[1]) {
            return true;
        }

        visited[row][column] = true;

        for(int[] dir :dirs) {
            int xDir = row;
            int yDir = column;
            while(xDir+ dir[0] >= 0 && yDir + dir[1] >=0 && xDir+ dir[0]<maze.length && column + yDir <maze[0].length &&
                    maze[row+xDir][column +yDir] != 1) {
                xDir = xDir+ dir[0];
                yDir = yDir + dir[1];
            }

            if(hasPaths(maze,xDir, yDir,destination)) {
                return true;
            }

        }

        return false;
    }

    public static void main(String[] args) {
        int[][] maze = {{0,0,1,0,0},
                {0,0,0,0,0},
                {0,0,0,1,0},
                {1,1,0,1,1},
                {0,0,0,0,0}
        };
        int[] start = {0,4};
        int[] destination = {4,4};
        new Maze().hasPath(maze, start, destination);
    }
}
