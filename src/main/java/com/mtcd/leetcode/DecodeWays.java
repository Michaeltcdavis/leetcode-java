package com.mtcd.leetcode;

public class DecodeWays {

    public static int waysToDecode(String s) {
        // initialize "max" as 1
        // for each num in nums after index 0
        // if != 0, max + 1
        // if prev = 1 or 2 and current < 7, max + 1,
        int prev = Character.getNumericValue(s.charAt(0));
        int max = prev == 0 ? 0 : 1;
        for (int i = 1; i < s.length(); i++) {
            int current = Character.getNumericValue(s.charAt(i));

            if (current != 0)
                max++;
            if ((prev == 1 || prev == 2) && current < 7)
                max++;

            prev = current;
        }
        return max;

    }

    public static void main(String[] args) {
        String s = "06";
        System.out.println(waysToDecode(s));
    }
}
