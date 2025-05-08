package com.mtcd.leetcode;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;


public class LongestConsecutiveSequence {

    public static int longestConsecutiveSequence(int[] ints) {
        if (ints.length < 1)
            return 0;
        Set<Integer> nums =
                Arrays.stream(ints).boxed().collect(Collectors.toSet());
        int longest = 0;
        for (Integer num : nums) {
            if (nums.contains(num - 1))
                continue;
            int localMax = 0;
            int current = num;
            while (nums.contains(current)) {
                localMax++;
                current++;
            }
            longest = Math.max(localMax, longest);
        }
        return longest;
    }

    public static void main(String[] args) {
        int[] input = new int[]{0, 3, 7, 2, 5, 8, 4, 6, 0, 1};
        System.out.println(longestConsecutiveSequence(input));
    }
}
