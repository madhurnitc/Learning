package org.learn.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class AllPathsFromSourceToTarget {

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        path.add(0);
        allPathsSourceTarget(graph, 0, result, path);
        return result;
    }

    private void allPathsSourceTarget(int[][] graph, int node, List<List<Integer>> result, List<Integer> path) {


        if( node == graph.length-1) {
            List<Integer> temp = new ArrayList<>(path);
            result.add(temp);
            return;
        }

        for(int neighbor : graph[node]) {
            path.add(neighbor);
            allPathsSourceTarget(graph, neighbor, result, path);
            path.remove(path.size()-1);   // this is to clear the path list once a neighbor has been completed.
        }
    }
}
