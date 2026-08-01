import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CopyGraph {

    public Map<Integer, List<Integer>> copy_graph(IntGraphNode node) {

        if(node == null) {
            return new HashMap<>();
        }

        Map<Integer, List<Integer>> adjList = new HashMap<>();
        dfs(node, adjList);
        return adjList;
    }

    private void dfs(IntGraphNode node, Map<Integer, List<Integer>> adjList) {

        if(adjList.containsKey(node.value)) {
            return ;
        }
        for(IntGraphNode n : node.neighbors){
           adjList.getOrDefault(node.value, new ArrayList<>()).add(n.value);
        }

        for(IntGraphNode n : node.neighbors) {
            dfs(n, adjList);
        }

    }

    public class IntGraphNode {
           int value;
            IntGraphNode[] neighbors;
}
}
