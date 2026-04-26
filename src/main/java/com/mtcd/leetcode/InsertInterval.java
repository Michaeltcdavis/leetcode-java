package com.mtcd.leetcode;

import java.util.LinkedList;

public class InsertInterval {

    public static int[][] insert(int[][] intervals, int[] newInterval) {
        LinkedList<int[]> result = new LinkedList<>();
        int newStart = newInterval[0];
        int newEnd = newInterval[1];
        int left = 0;
        while (left < intervals.length) {
            int leftStart = intervals[left][0];
            int leftEnd = intervals[left][1];
            if (leftStart < newStart) {
                if (leftEnd < newStart) {
                    result.add(intervals[left]);
                    left++;
                    continue;
                } else {
                    if (leftEnd > newEnd) {
                        return toIntArray(theRest(left, intervals, result));
                    } else {
                        return toIntArray(rightPointer(leftStart, newEnd, left + 1, intervals, result));
                    }
                }
            } else {
                if (leftStart > newEnd) {
                    result.add(newInterval);
                    return toIntArray(theRest(left, intervals, result));
                } else {
                    if (leftEnd > newEnd) {
                        result.add(new int[]{newStart, leftEnd});
                        return toIntArray(theRest(left + 1, intervals, result));
                    } else {
                        return toIntArray(rightPointer(newStart, newEnd, left + 1, intervals, result));
                    }
                }
            }
        }
        result.add(newInterval);
        return result.toArray(new int[result.size()][]);
    };

    private static LinkedList<int[]> rightPointer(int start, int newEnd, int right, int[][] intervals, LinkedList<int[]> result) {
        while (right < intervals.length) {
            int rightStart = intervals[right][0];
            int rightEnd = intervals[right][1];
            if (rightStart <= newEnd) {
                if (rightEnd >= newEnd) {
                    result.add(new int[]{start, rightEnd});
                    return theRest(right + 1, intervals, result);
                } else if (right == intervals.length - 1) {
                    result.add(new int[]{start, newEnd});
                    return theRest(right + 1, intervals, result);
                } else {
                    right++;
                    continue;
                }
            } else {
                result.add(new int[]{start, newEnd});
                return theRest(right, intervals, result);
            }
        }
        return null;
    }

    private static LinkedList<int[]> theRest(int start, int[][] intervals, LinkedList<int[]> result) {
        for (int i = start; i < intervals.length; i++) {
            result.add(intervals[i]);
        }
        return result;
    }

    private static int[][] toIntArray(LinkedList<int[]> list) {
        return list.toArray(new int[list.size()][]);
    }
}
