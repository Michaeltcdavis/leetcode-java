package com.mtcd.leetcode;

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

    public static void main(String[] args) {
        int[] input = new int[]{2, 4, 3, 9, 11, 2};
        System.out.println(maxNonAdjacentSum(input));
    }
}
