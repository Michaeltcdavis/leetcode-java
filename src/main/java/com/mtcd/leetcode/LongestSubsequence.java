package com.mtcd.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LongestSubsequence {

    public static int longestIncreasingSubSequence(int[] ints) {
        int max = 1;
        int[] subs = new int[ints.length];
        Arrays.fill(subs, 1);

        for (int i = 1; i < ints.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (ints[j] < ints[i]) {
                    subs[i] = Math.max(subs[i], subs[j] + 1);
                }
            }
            max = Math.max(max, subs[i]);
        }
        return max;
    }

    public static int longestIncreasingSubSequenceBS(int[] ints) {
        int size = ints.length;
        List<Integer> result = new ArrayList<>();
        result.add(ints[0]);
        for (int i = 1; i < size; i++) {
            if (ints[i] > result.get(result.size() - 1)) {
                result.add(ints[i]);
            } else {
                int search = Collections.binarySearch(result, ints[i]);
                if (search < 0)
                    search = -(search + 1);
                result.set(search, ints[i]);
            }
        }
        return result.size();
    }

    public static int longestCommonSubsequenceDP(String text1, String text2) {
        //    J O H N ø
        // R  2 2 1 1 0
        // O  2 2 1 1 0
        // N  1 1 1 1 0
        // ø  0 0 0 0 0
        int[][] matrix = new int[text1.length() + 1][text2.length() + 1];

        for (int i = text1.length() - 1; i >= 0; i--) {
            for (int j = text2.length() - 1; j >= 0; j--) {
                if (text1.charAt(i) == text2.charAt(j)) {
                    // if there is a match, take diagonal value + 1
                    matrix[i][j] = matrix[i + 1][j + 1] + 1;
                } else {
                    // if no match, take highest adjacent value
                    matrix[i][j] = Math.max(matrix[i + 1][j], matrix[i][j + 1]);
                }
            }
        }
        return matrix[0][0];
    }

    public static void main(String[] args) {
        int[] input = new int[]{10, 7, 8, 3, 16, 27, 1};
        System.out.println(longestIncreasingSubSequenceBS(input));

        System.out.println(longestCommonSubsequenceDP("abcde", "ace"));
    }
}
