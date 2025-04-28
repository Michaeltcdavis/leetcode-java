package com.mtcd.leetcode;

public class DecodeWays {

    public static int waysToDecode(String s) {
        // initialize "max" as 1
        // for each num in nums after index 0
        // if != 0, max + 1
        // if prev = 1 or 2 and current < 7, max + 1,
        int max = 1;
        for (int i = 1; i < s.length(); i++) {
            int current = Integer.valueOf(s.charAt(i));
            int prev = Integer.valueOf(s.charAt(i - 1));
            if (current != 0)
                max++;
            if ((prev == 1 || prev == 2) && current < 7)
                max++;
        }
        return max;

    }

    public static void main(String[] args) {
        String s = "12";
        System.out.println(waysToDecode(s));
    }
}
