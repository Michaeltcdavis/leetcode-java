package com.mtcd.leetcode;

public class DecodeWays {

    public static int waysToDecode(String s) {
        int prev = Character.getNumericValue(s.charAt(0));
        if (prev == 0)
            return 0; // no way to decode leading zero

        boolean prevFree = false; // is prev available to group with prev - 1
        int max = 1;
        for (int i = 1; i < s.length(); i++) {
            int current = Character.getNumericValue(s.charAt(i));

            if (current == 0) {
                if (prev == 0 || prev > 2)
                    return 0;
                else if (prevFree) {
                    max--;
                    prevFree = false;
                }
            } else if (prevFree) {
                max++;
            } else if (prev == 1 || prev == 2 && current < 7) {
                max++;
                prevFree = true;
            }
            prev = current;
        }
        return max;

    }

    public static void main(String[] args) {
        String s = "897078";
        System.out.println(waysToDecode(s));
    }
}
