import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem323 {

    Map<Integer, List<Integer>> adjList = new HashMap<>();
    boolean[] visited ;
    public int countComponents(int n, int[][] edges) {
        int result = 0;
        visited = new boolean[n];
        for(int[] edge : edges) {

            int n1 = edge[0];
            int n2 = edge[1];
            adjList.putIfAbsent(n1, new ArrayList<>());
            adjList.putIfAbsent(n2, new ArrayList<>());
            adjList.get(n1).add(n2);
            adjList.get(n2).add(n1);
        }

        for(Map.Entry<Integer,List<Integer> >entry : adjList.entrySet()){
            int source = entry.getKey();
            if(!visited[source]) {
                result++;
                visited[source] = true;
                dfs(source);
            }

        }
        return result++;
    }

    private void dfs(int source) {
        List<Integer> neighbours = adjList.get(source);
        for(int neighbor : neighbours){
            if(!visited[neighbor]){
                dfs(neighbor);
            }
        }
    }
}
