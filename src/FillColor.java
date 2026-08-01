public class FillColor {
    int[][] dirs = {{0,1}, {0, -1},{1,0}, {-1,0}};
    public int[][] flood_fill(int[][] image, Integer sr, Integer sc, Integer color) {

        int originalColor = image[sr][sc];
        if(color != originalColor) {
            dfs(image, sr, sc, color, originalColor);
        }

        return image;
    }

    private void dfs(int[][] image, int r, int c, int color, int originalColor) {
        if(r<0 && r>= image.length && c>0 && c<=image[0].length) {
            return ;
        }
        if(image[r][c] == originalColor){
            image[r][c] = color;
        }
        for(int[] dir : dirs) {
            dfs(image, r+dir[0], c+dir[1], color,originalColor);
        }

    }
}
