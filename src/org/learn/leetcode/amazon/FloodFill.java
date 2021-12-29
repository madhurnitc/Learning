package org.learn.leetcode.amazon;

public class FloodFill {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int oldColor = image[sr][sc];
        if(image[sr][sc] != newColor) {
            dfs(image,sr, sc,  newColor, oldColor);
        }
        return image;
    }

    private void dfs(int[][] image, int i, int j, int newColor, int oldColor) {
        if(image[i][j] == oldColor) {
            image[i][j] = newColor;
            if(i>0) dfs(image, i-1, j, newColor, oldColor);
            if(i< image.length) dfs(image, i+1, j, newColor, oldColor);
            if(j>0) dfs(image,i, j-1, newColor, oldColor);
            if(j<image[0].length) dfs(image,i, j+1, newColor,oldColor);
        }
    }
    public static void main(String[] args) {
        int[][] image = {{1,1,1},
                {1,1,0},
                {1,0,1}};

        new FloodFill().floodFill(image,1,1,2);
    }
}
