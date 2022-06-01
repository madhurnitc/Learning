import java.util.*;

public class NetworkDelayTime {

    Map<Integer, List<Node>> adjList = new HashMap<>();
    public int networkDelayTime(int[][] times, int n, int k) {

        for(int[] time : times) {

            adjList.putIfAbsent(time[0], new ArrayList<>());
            adjList.get(time[0]).add(new Node(time[1], time[2]) );
        }

        int[] receivedAt = new int[n+1];
        Arrays.fill(receivedAt, Integer.MAX_VALUE);
        runShortestTimeFirst(receivedAt, k);

        int answer = Integer.MIN_VALUE;
        for(int i =1; i< receivedAt.length; i++){
            answer = Math.max(receivedAt[i], answer );
        }

        return answer == Integer.MAX_VALUE ?-1: answer;

    }
    public void runShortestTimeFirst(int[] receivedAt, int source) {
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparing(Node::getTime));
        pq.offer(new Node(source, 0));
        receivedAt[source] =0;

        while(!pq.isEmpty()) {

            Node smallestNode = pq.remove();
            if(smallestNode.time > receivedAt[smallestNode.getId()]) {
                continue;
            }

            if(!adjList.containsKey(smallestNode.getId())) {
                continue;
            }

            for(Node adjNode : adjList.get(smallestNode.getId())){
                if(adjNode.time + smallestNode.time < receivedAt[adjNode.getId()]){
                    receivedAt[adjNode.getId()] = adjNode.time + smallestNode.time;
                    pq.offer(new Node(adjNode.getId(), receivedAt[adjNode.getId()]));
                }
            }
        }


    }

    public class Node {

        public int getId() {
            return id;
        }


        public int getTime() {
            return time;
        }


        private int id;
        private int time;
        public Node(int id, int time) {
            this.id = id;
            this.time = time;
        }
    }

}
