package rohit.leetcode;

import java.util.*;
/*
There are a total of numCourses courses you have to take, labeled from 0 to numCourses-1.Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]
Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?

Example 1:
Input: numCourses = 2, prerequisites = [[1,0]]
Output: true
Explanation: There are a total of 2 courses to take.
             To take course 1 you should have finished course 0. So it is possible.
Example 2:
Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
Output: false
Explanation: There are a total of 2 courses to take.
             To take course 1 you should have finished course 0, and to take course 0 you should
             also have finished course 1. So it is impossible.
 */
public class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        boolean result = false;
        Map<Integer, Set<Integer>> map = new HashMap<>();
        Map<Integer, Integer> degree = new HashMap<>();
        for(int i = 0 ; i < numCourses ; i++){
            degree.put(i,0);
        }

        for(int[] pre : prerequisites){
            int course = pre[0];
            int preCourse = pre[1];
            if(!map.containsKey(course)){
                map.put(course,new HashSet<>());
            }
            if(!map.get(course).contains(preCourse)){
                degree.put(preCourse, degree.get(preCourse) + 1);
                map.get(course).add(preCourse);
            }
        }
        Queue<Integer> queue = new LinkedList<>();

        for(int key : degree.keySet()){
            if(degree.get(key) == 0){
                queue.offer(key);
            }
        }
        int count = 0;
        while(!queue.isEmpty()){
            int current = queue.poll();
            count++;
            if(map.containsKey(current)){
                for(Integer couse : map.get(current)){
                    degree.put(couse,degree.get(couse) - 1);
                    if(degree.get(couse) == 0)
                        queue.add(couse);
                }
            }
        }

        return count == numCourses;
    }
}
