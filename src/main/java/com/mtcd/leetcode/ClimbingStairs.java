package com.mtcd.leetcode;

public class ClimbingStairs {

    public static int distinctWaysToClimb(int n) {
        // an array of steps (1s/2s) must add up to the total n
        // the amount of different combos of 1s and twos should be n - n/2
        // the length of each combo will be between n and n/2 or n/2 + 1 for odd
        //number of 2s will start at zero and increase each time from n - n/2
        //the distinct order of each combo will be n!/(2s!*1s!)
        int result = (n % 2 == 0) ? 2 : 1; // case where all are ones or twos
        int minSteps = n / 2 + 1;
        int twos = 1;
        for (int i = n - 1; i >= minSteps; i--) {
            result += factorial(i) / (factorial(twos) * factorial(i - twos));
            twos++;
        }
        return result;
    }

    private static int factorial(int n) {
        int result = n;
        for (int i = n - 1; i > 0; i--)
            result *= i;
        return result;
    }


    public static void main(String[] args) {
        System.out.println(distinctWaysToClimb(4));
    }
}
