package org.learn.leetcode.easy;

import java.util.*;

public class CourseSchedule {

    Map<Integer, Set<Integer>> coursePreq = new HashMap<>();
    Set<Integer> visited = new HashSet<>();
    Stack<Integer> stack = new Stack<>();

    public boolean canFinish(int numCourses, int[][] prerequisites) {


        for (int i = 0; i < prerequisites.length; i++) {

            int course = prerequisites[i][0];
            int preReqCourse = prerequisites[i][1];

            if (!coursePreq.containsKey(course)) {
                coursePreq.put(course, new HashSet<Integer>());
            }

            coursePreq.get(course).add(preReqCourse);
        }

        for (Integer entry : coursePreq.keySet()) {
            if (!visited.contains(entry)) {
                dfs(entry);
            }

        }

        return stack.size() == numCourses;
    }

    private void dfs(Integer course) {
        visited.add(course);

        if (coursePreq.containsKey(course)) {
            Set<Integer> preReqSet = coursePreq.get(course);
            for (Integer preReqCourse : preReqSet) {
                if (!visited.contains(coursePreq)) {
                    dfs(preReqCourse);
                }

            }
        }


        stack.push(course);

    }

    public static void main(String[] args) {
        int[][] pre = new int[][]{{1, 0}};

        System.out.println(new CourseSchedule().canFinish(2, pre));

    }
}
