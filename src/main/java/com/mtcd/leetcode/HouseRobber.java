package com.mtcd.leetcode;

import java.util.Arrays;

public class HouseRobber {
    /**
     * Returns the largest sum possible not using adjacent values
     *
     * @param vals values to sum
     * @return the sum
     */
    public static int maxNonAdjacentSum(int[] vals) {
        int prevMax = 0;
        int max = 0;
        for (int i = 0; i < vals.length; i++) {
            int current = vals[i] + prevMax;
            if (current > max) {
                prevMax = max;
                max = current;
            } else {
                prevMax = max;
            }
        }
        return max;
    }

    public static int maxNonAdjacentCircleSum(int[] vals) {
        int oneMax = maxNonAdjacentSum(Arrays.copyOfRange(vals, 0,
                vals.length - 1));
        int twoMax = maxNonAdjacentSum(Arrays.copyOfRange(vals, 1,
                vals.length));
        return Math.max(oneMax, twoMax);
    }

    public static void main(String[] args) {
        int[] input = new int[]{1, 2, 15, 11, 3, 6, 10};
        System.out.println(maxNonAdjacentCircleSum(input));
    }
}
