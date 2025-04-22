package com.mtcd.leetcode;

import java.util.Arrays;

public class MinimumInArray {

    public static int rotatedSortedMin(int[] ints) {
        if (ints[ints.length - 1] >= ints[0])
            return ints[0];

        int middle = ints.length / 2;
        if (ints[middle] < ints[0])
            return rotatedSortedMin(Arrays.copyOfRange(ints, 1, middle + 1));

        return rotatedSortedMin(Arrays.copyOfRange(ints, middle, ints.length));
    }

    public static void main(String[] args) {
        int[] input = new int[]{1, 2, 3, 4};
    }
}
