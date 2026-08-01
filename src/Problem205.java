/*
import java.util.*;

public class Problem205 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        int[] topologicalSort = new int[numCourses];
        int[] inDegree = new int[numCourses];

        for(int[] preq : prerequisites) {

            int pre = preq[1];
            int post = preq[0];
            List<Integer> destList = adjList.getOrDefault(pre, new ArrayList<>());
            destList.add(post);
            adjList.put(pre, destList);
            inDegree[post]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for(int i =0; i<inDegree.length; i++) {
            if(inDegree[i] == 0) {
                queue.offer(i);
            }
        }

        int i = 0;
        while(!queue.isEmpty()) {

            int course = queue.poll();
            topologicalSort[i++] = course;
            for(Integer destList : adjList.get(course)) {

                for(int post : destList){
                    inDegree[post]--;
                    if(inDegree[post]==0) {
                        queue.offer(post);
                    }
                }
            }
        }

        return i == numCourses;
    }


}


*/
