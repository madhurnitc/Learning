package org.learn.leetcode.amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindCriticalConnections {

    List<Integer>[] graph;
    int[] visitedTimes;
    int[] lowTimes;
    int time;
    List<List<Integer>> criticalConnections;
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        graph = new ArrayList[n];
        visitedTimes = new int[n];
        lowTimes = new int[n];
        criticalConnections = new ArrayList<>();
        buildGraph(connections);
        boolean[] visited = new boolean[n];
        dfs(visited, 0, -1);

        return criticalConnections;
    }

    private void dfs(boolean[] visited, int currentNode, int parentNode) {

        visited[currentNode] = true;
        visitedTimes[currentNode] = lowTimes[currentNode] = time++;
        for(int neighbor : graph[currentNode]) {
            if(neighbor == parentNode) continue;
            if(!visited[neighbor]) {
                dfs(visited, neighbor, currentNode);
                lowTimes[currentNode] = Math.min(lowTimes[currentNode],lowTimes[neighbor] );
                if(visitedTimes[currentNode] < lowTimes[neighbor]) {
                    criticalConnections.add(Arrays.asList(currentNode, neighbor));
                }
            }else {
                lowTimes[currentNode] = Math.min(lowTimes[currentNode], visitedTimes[neighbor] );
            }
        }
    }

    private void buildGraph(List<List<Integer>> connections) {

        for(int i = 0; i<graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        for(List<Integer> connection : connections) {
            int a = connection.get(0);
            int b = connection.get(1);
            graph[a].add(b);
            graph[b].add(a);
        }
    }
}
