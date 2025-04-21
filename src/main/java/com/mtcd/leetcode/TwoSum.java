package com.mtcd.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.stream.Collectors;

public class TwoSum {

    /**
     * Method takes an integer array and a target sum. The method returns an
     * array of
     * two values which add up to the target sum. If no two values exist, the
     * method returns null.
     *
     * @param ints   The array of integers
     * @param target The target sum
     * @return The array of integers which add up to the target sum
     */
    public static int[] twoSum(int[] ints, int target) {
        HashMap<Integer, Integer> cache = new HashMap<>();
        for (int i = 0; i < ints.length; i++) {
            int pair = target - ints[i];
            if (cache.containsKey(pair))
                return new int[]{cache.get(pair), i};
            cache.put(ints[i], i);
        }
        return null;
    }

    public static void main(String[] args) {
        int[] result = twoSum(new int[]{1,
                2, 3, 4}, 6);

        String out = Arrays.stream(result)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(
                        ","));

        System.out.println(out);
    }
}
