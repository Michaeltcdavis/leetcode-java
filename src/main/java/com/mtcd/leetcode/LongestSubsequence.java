package com.mtcd.leetcode;

import java.util.Arrays;

public class LongestSubsequence {

    public static int longestIncreasingSubSequence(int[] ints) {
        int max = 1;
        int[] subs = new int[ints.length];
        Arrays.fill(subs, 1);

        for (int i = 1; i < ints.length; i++) {
            int localMax = 0;
            for (int j = i - 1; j >= 0; j--) {
                if (ints[j] < ints[i]) {
                    localMax = Math.max(localMax, subs[j]);
                }
            }
            subs[i] = localMax + 1;
            max = Math.max(max, subs[i]);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] input = new int[]{10, 7, 8, 3, 16, 27, 1};
        System.out.println(longestIncreasingSubSequence(input));
    }
}
