package com.mtcd.leetcode;

public class JumpGame {

    /**
     * Determines if the last index of an array of ints can be reached from the
     * first index, if the number of forward index movements from each position
     * is determined by the value of each int in the array.
     *
     * @param ints the array of possible movements (jumps) from each position
     * @return true if possible to reach the last index, otherwise false
     */
    public static boolean canReachLast(int[] ints) {
        int reachable = ints[0];
        for (int i = 0; i < ints.length; i++) {
            if (i > reachable)
                return false;

            reachable = Math.max(i + ints[i], reachable);

            if (reachable >= ints.length - 1)
                return true;
        }
        return true;
    }

    public static void main(String[] args) {
        int[] input = new int[]{2, 3, 1, 1, 4};
        int[] falseInput = new int[]{3, 2, 1, 0, 4};
        System.out.println(canReachLast(input)); // tr
        System.out.println(canReachLast(falseInput)); // false

    }
}
