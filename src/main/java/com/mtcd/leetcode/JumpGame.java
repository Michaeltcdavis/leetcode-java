package com.mtcd.leetcode;

public class JumpGame {

    public static boolean canReachLast(int[] ints) {
        // keep record of available steps (int)
        // for each int, reduce available steps by 1
        //      if current steps greater than available, avail = current
        // if avail = 0 return false, else return true
        int avail = ints[0];
        for (int i = 1; i < ints.length; i++) {
            avail--;

            if (ints[i] > avail)
                avail = ints[i];

            if (avail == 0)
                return false;
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
