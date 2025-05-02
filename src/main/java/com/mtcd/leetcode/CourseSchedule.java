package com.mtcd.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CourseSchedule {
    /**
     * Given a number of courses and a matrix of prerequisites, return
     * whether the given courses can be taken or whether the prerequisites
     * conflict
     *
     * @param numCourses    The number of courses to be taken
     * @param prerequisites An array of 2-entry arrays representing the course
     *                      (index 0) and its prerequisite (index 1)
     * @return true if the courses can be taken in requisite order
     */
    public static boolean canTakeCourses(int numCourses,
                                         int[][] prerequisites) {
        Map<Integer, Set<Integer>> prereqs = new HashMap<>();

        for (int[] pair : prerequisites) {
            if (prereqs.containsKey(pair[0])) {
                prereqs.get(pair[0]).add(pair[1]);
            } else {
                HashSet<Integer> pres = new HashSet<>();
                pres.add(pair[1]);
                prereqs.put(pair[0], pres);
            }
        }

        for (Integer course : prereqs.keySet()) {
            if (!canTakeCourse(course, prereqs, new HashSet<>()))
                return false;
        }
        return true;
    }

    private static boolean canTakeCourse(Integer course, Map<Integer,
            Set<Integer>> prereqs, Set<Integer> path) {
        if (path.contains(course))
            return false;

        path.add(course);

        if (prereqs.get(course) == null)
            return true;

        for (Integer pre : prereqs.get(course)) {
            if (!canTakeCourse(pre, prereqs, path))
                return false;
        }
        path.remove(course);
        prereqs.put(course, null);
        return true;
    }

    public static void main(String[] args) {
        int[][] prereqs = new int[][]{new int[]{0, 2}, new int[]{1, 2},
                new int[]{1, 4}, new int[]{1, 5}, new int[]{2, 3}, new int[]{3, 4},
                new int[]{4, 5}};
        System.out.println(canTakeCourses(6, prereqs));
    }
}
