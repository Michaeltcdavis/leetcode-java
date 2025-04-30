package com.mtcd.leetcode;

public class JumpGame {

    public static boolean canReachLast(int[] ints) {
        // initialize array of length ints with 0=true
        // iterate through from start
        //if ints[i] = true, then make all accessible ints true
        // find next true int and follow the same
        boolean[] canReach = new boolean[ints.length];
        canReach[0] = true;
        for (int i = 0; i < ints.length; i++) {
            if (canReach[i] == true)
                for (int j = i + 1; j <= i + ints[i] && j < ints.length; j++)
                    canReach[j] = true;
        }
        return canReach[ints.length - 1];
    }

    public static void main(String[] args) {
        int[] input = new int[]{2, 3, 1, 1, 4};
        int[] falseInput = new int[]{3, 2, 1, 0, 4};
        System.out.println(canReachLast(input)); // tr
        System.out.println(canReachLast(falseInput)); // false

    }
}
