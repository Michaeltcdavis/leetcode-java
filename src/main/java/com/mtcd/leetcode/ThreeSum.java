package com.mtcd.leetcode;

import java.util.*;
import java.util.stream.Collectors;

public class ThreeSum {

    public static Set<List<Integer>> subTripletsWhichSum(int[] ints,
                                                         int target) {
        HashSet<Integer> set = new HashSet<>();
        Set<List<Integer>> trips = new HashSet<>();
        for (int i : ints) {
            int remainder = target - i;
            List<List<Integer>> twoSums = twoSum(set, remainder);
            for (List<Integer> pair : twoSums) {
                pair.add(i);
                Collections.sort(pair);
                trips.add(pair);
            }
            set.add(i);
        }
        return trips;
    }

    private static List<List<Integer>> twoSum(HashSet<Integer> ints,
                                              int target) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i : ints) {
            int remainder = target - i;
            if (ints.contains(remainder)) {
                List<Integer> twoSum = list(i, remainder);
                result.add(twoSum);
            }
        }
        return result;
    }

    private static List<Integer> list(int... ints) {
        List<Integer> list = new ArrayList<>();
        for (int i : ints)
            list.add(i);
        return list;
    }

    public static void main(String[] args) {
        int[] input = new int[]{-1, 0, 2, 3, -1, -4};
        Set<List<Integer>> result = subTripletsWhichSum(input, 0);
        for (List<Integer> threeSum : result) {
            System.out.println(threeSum.stream().map(String::valueOf).collect(Collectors.joining(", ")));
        }
    }
}
