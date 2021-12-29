package org.learn.leetcode.amazon;

import java.util.ArrayList;
import java.util.List;

public class NumberOfConnectedComponentsInUndirectedGraph {

    public int countComponents(int n, int[][] edges) {

        int result = 0;

        List<List<Integer>> adjacencyMatrix = new ArrayList<>();
        boolean[] visited = new boolean[n];
        for(int i = 0 ; i< n; i++) {
            adjacencyMatrix.add(new ArrayList<>());
        }

        for(int[] edge : edges) {
            adjacencyMatrix.get(edge[0]).add(edge[1]);
            adjacencyMatrix.get(edge[1]).add(edge[0]);
        }

        for (int i = 0; i<n; i++) {
            if(!visited[i]) {
                dfs(adjacencyMatrix, i, visited);
                result++;
            }

        }
        return result++;
    }

    private void dfs(List<List<Integer>> adjacencyMatrix, int i, boolean[] visited) {
        List<Integer> adjacencyList = adjacencyMatrix.get(i);
        visited[i] = true;
        for(int j : adjacencyList) {
            if(!visited[i]) {
                dfs(adjacencyMatrix, j, visited);
            }

        }
    }


    public static void main(String[] args) {
        int[][] graph = {{0,1}, { 1,2}, {3,4}};
        new NumberOfConnectedComponentsInUndirectedGraph().countComponents(5, graph);
    }
}
