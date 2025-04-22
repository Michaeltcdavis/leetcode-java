package com.mtcd.leetcode;

import java.util.*;
import java.util.stream.Collectors;

public class ThreeSum {

    public static Set<List<Integer>> subTripletsWhichSum(int[] ints,
                                                         int target) {
        List<Integer> used = new ArrayList<>();
        Set<List<Integer>> trips = new HashSet<>();
        for (int i : ints) {
            int remainder = target - i;
            List<List<Integer>> twoSums = twoSum(used, remainder);
            for (List<Integer> pair : twoSums) {
                pair.add(i);
                Collections.sort(pair);
                trips.add(pair);
            }
            used.add(i);
        }
        return trips;
    }

    private static List<List<Integer>> twoSum(List<Integer> ints,
                                              int target) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i : ints) {
            int remainder = target - i;
            if (ints.contains(remainder) && notSameNum(i, remainder, ints)) {
                List<Integer> twoSum = list(i, remainder);
                result.add(twoSum);
            }
        }
        return result;
    }

    private static boolean notSameNum(int i, int remainder, List<Integer> ints) {
        return i == remainder ? hasMultiple(ints, i) : true;
    }

    private static boolean hasMultiple(List<Integer> ints, int i) {
        int count = 0;
        for (int in : ints) {
            if (in == i)
                count++;
        }
        return count > 1;
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
