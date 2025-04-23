package com.mtcd.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class ThreeSum {

    public static List<List<Integer>> subTripletsWhichSum(int[] ints,
                                                          int target) {
        List<List<Integer>> triplets = new ArrayList<>();
        Arrays.sort(ints);
        int right = 0;
        int left = ints.length - 1;
        // -4, -1, -1, 0, 2, 3
        for (int i = 0; i < ints.length && ints[i] <= target; i++) {
            if (i == 0 || ints[i] != ints[i - 1]) {
                Collection<List<Integer>> twoSums = twoSum(ints, i + 1,
                        target - ints[i]);
                for (List<Integer> twoSum : twoSums)
                    triplets.add(add(twoSum, ints[i]));
            }
        }
        return triplets;
    }

    private static List<Integer> add(List<Integer> intList, int anInt) {
        List<Integer> result = new ArrayList<>();
        result.addAll(intList);
        result.add(anInt);
        return result;
    }

    private static Collection<List<Integer>> twoSum(int[] ints, int start,
                                                    int target) {
        Collection<List<Integer>> sums = new ArrayList<>();
        for (int i = start; i < ints.length - 1; i++) {
            if (ints[i] == ints[i - 1] && i != start)
                continue;

            int remainder = target - ints[i];
            for (int j = i + 1; j < ints.length; j++) {
                if (ints[j] == ints[j - 1] && ints[j] != ints[i])
                    continue;
                if (ints[j] > remainder)
                    break;
                if (ints[j] == remainder)
                    sums.add(Arrays.asList(ints[i], ints[j]));
            }
        }
        return sums;
    }

    public static void main(String[] args) {
        int[] input = new int[]{-1, 0, 2, 3, -1, -4};
        List<List<Integer>> result = subTripletsWhichSum(input, 4);
        for (List<Integer> threeSum : result) {
            System.out.println(threeSum.stream().map(String::valueOf).collect(Collectors.joining(", ")));
        }
    }
}
