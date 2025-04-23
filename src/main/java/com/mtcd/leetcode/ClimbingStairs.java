package com.mtcd.leetcode;

public class ClimbingStairs {

    public static int distinctWaysToClimb(int n) {
        // distinct steps to reach i = distinct to reach i - 1 + distinct to
        // reach i - 2
        if (n < 2)
            return 1;

        int one = 1;
        int two = 2;
        for (int i = 3; i <= n; i++) {
            int temp = one + two;
            one = two;
            two = temp;
        }
        return two;
    }

    public static void main(String[] args) {
        System.out.println(distinctWaysToClimb(5));
    }
}
