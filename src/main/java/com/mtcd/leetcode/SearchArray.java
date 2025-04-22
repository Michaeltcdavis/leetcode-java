package com.mtcd.leetcode;

import java.util.Arrays;

public class SearchArray {

    public static int searchRotatedSortedArray(int[] ints, int target) {
        int start = 0;
        int end = ints.length - 1;
        while (start < end) {
            int middle = (start + end) / 2;
            int middleVal = ints[middle];
            if (middleVal == target)
                return middle;
            if (ints[start] > ints[end]) {
                if (middleVal > ints[start] && middleVal > target) {
                    end = middle;
                } else if (middleVal > ints[start] && middleVal <= target) {
                    start = middle;
                } else if (middleVal < ints[start] && middleVal > target) {
                    end = middle;
                } else {
                    if (target >= ints[start])
                        end = middle;
                    else
                        start = middle;
                }
            } else if (target <= end && target >= start) {
                return Arrays.binarySearch(Arrays.copyOfRange(ints, start,
                        end + 1), target) + start;
            } else {
                return -1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] input = new int[]{5, 6, 1, 2, 3, 4};
        System.out.println(searchRotatedSortedArray(input, 4));
    }
}
