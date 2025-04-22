package com.mtcd.leetcode;

public class MaxProductSubArray {

    /**
     * Returns the largest product that can be created from a continuous sub
     * array of an array.
     *
     * @param ints
     * @return the product value of the largest sub array.
     */
    public static int maxSubProduct(int[] ints) {
        if (ints.length < 1)
            return 0;

        int min = ints[0];
        int max = ints[0];
        int result = max;
        for (int i = 1; i < ints.length; i++) {
            int self = ints[i];
            int byMin = min * self;
            int byMax = max * self;
            min = Math.min(self, Math.min(byMin, byMax));
            max = Math.max(self, Math.max(byMin, byMax));
            if (max > result)
                result = max;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] ints = new int[]{2, 3, -2, 4};
        System.out.println(maxSubProduct(ints));
    }
}
