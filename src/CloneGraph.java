import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CloneGraph {
    Map<Integer, Node> visited = new HashMap<>();
    public Node cloneGraph(Node node) {

        if(node == null){
            return node;
        }
        if(visited.containsKey(node.val)){
            return visited.get(node.val);
        }
        Node cloneNode = new Node(node.val, new ArrayList<>());
        visited.put(node.val, cloneNode);
        for(Node n: node.neighbors){
            if(!visited.containsKey(n.val)) {
                cloneNode.neighbors.add(cloneGraph(n));
            }
        }
        return cloneNode;
    }
    public class Node {
        public int val;
        public List<Node> neighbors;
        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }
}
