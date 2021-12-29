package org.learn.leetcode.amazon;

import java.util.*;

public class CourseSchedule2 {

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        int[] inDegree = new int[numCourses];
        int[] toplogicalorder = new int[numCourses];

        for (int[] prereq : prerequisites) {

            int dest = prereq[0];
            int src = prereq[1];

            List<Integer> adj = adjList.getOrDefault(src, new ArrayList<>());
            adj.add(dest);
            adjList.put(src,adj);
            inDegree[dest]++;

        }

        Queue<Integer> queue = new LinkedList<>();

        for(int i = 0 ; i< inDegree.length ; i++) {
            if(inDegree[i] == 0) {
                queue.offer(i);
            }
        }


        int i = 0;
        while(!queue.isEmpty()) {
            int src = queue.poll();
            toplogicalorder[i++] = src;
            List<Integer> destList = adjList.get(src);

            if(destList != null) {
                for(int dest : destList) {
                    inDegree[dest]--;
                    if(inDegree[dest] == 0) {
                        queue.offer(dest);
                    }
                }
            }

        }

        if( i == numCourses) {
            return toplogicalorder;
        }

        return new int[0];
    }

    public static void main(String[] args) {
        int[][] courses = {{1,0}};
        new CourseSchedule2().findOrder(2, courses);
    }

}
