import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class CourseSchedule2 {
        public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] inDegree = new int[numCourses];
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        for(int[] prereq: prerequisites){
            int first = prereq[1];
            int second = prereq[0];
            adjList.computeIfAbsent(first, k->new ArrayList()).add(second);
            inDegree[second]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i =0; i<numCourses; i++){
            if(inDegree[i] == 0){
                q.offer(i);
            }
        }
        int count =0;
        List<Integer> result = new ArrayList<>();
        while(!q.isEmpty()) {
            count++;
            int course = q.poll();
            result.add(course);
            for(int n : adjList.getOrDefault(course, new ArrayList<>())) {
                inDegree[n]--;
                if(inDegree[n] == 0) {
                    q.offer(n);
                }
            }
        }
        return count != numCourses ? new int[0]: result.toArray(new int[result.size()]) ;
    }

}
