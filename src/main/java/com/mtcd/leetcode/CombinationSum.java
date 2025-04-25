package com.mtcd.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CombinationSum {

    public static List<List<Integer>> summingCombinations(int[] candidates,
                                                          int target) {
        List<List<Integer>> result = new ArrayList<>();

        addSummingCombos(candidates, 0, result,
                new ArrayList<>(),
                target);

        return result;
    }

    private static void addSummingCombos(int[] candidates, int start,
                                         List<List<Integer>> result,
                                         ArrayList<Integer> current,
                                         int target) {
        if (target == 0) {
            result.add(new ArrayList<>(current));
            return;
        }

        if (target < 0)
            return;

        for (int i = start; i < candidates.length; i++) {
            current.add(candidates[i]);
            addSummingCombos(candidates, i, result, current,
                    target - candidates[i]
            );
            current.remove(current.size() - 1);
        }

    }

    public static void main(String[] args) {
        int[] candidates = new int[]{2, 3, 6, 7};
        List<List<Integer>> result = summingCombinations(candidates, 7);
        for (List<Integer> combo : result)
            System.out.println(combo.stream().map(String::valueOf).collect(Collectors.joining(",")));
    }
}
