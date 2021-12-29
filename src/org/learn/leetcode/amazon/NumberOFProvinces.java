package org.learn.leetcode.amazon;

public class NumberOFProvinces {

    public int findCircleNum(int[][] isConnected) {
        int numOfProvinces=0;
        boolean[] visited = new boolean[isConnected.length];
        for(int i = 0; i<isConnected.length; i++) {
            if(!visited[i]) {
                dfs(isConnected, visited, i);
                numOfProvinces++;
            }
        }

        return numOfProvinces;
    }

    private void dfs(int[][] isConnected, boolean[] visited, int i) {
        visited[i] = true;
        for(int j = 0 ; j<isConnected.length; j++) {
            if(isConnected[i][j] == 1 && !visited[j]) {
                dfs(isConnected, visited, j);
            }
        }
    }
}
