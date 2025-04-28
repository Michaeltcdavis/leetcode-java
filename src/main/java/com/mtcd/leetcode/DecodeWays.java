package com.mtcd.leetcode;

public class DecodeWays {

    public static int waysToDecode(String s) {
        if (s.charAt(0) == '0')
            return 0; // no way to decode leading zero

        int one = 1; //max ways to decode from i - 1
        int two = 1; // max ways to decode from i - 2

        for (int i = 1; i < s.length(); i++) {
            int current = 0;

            if (s.charAt(i) != '0')
                current = one; // current num can be treated on its own

            int val = Integer.parseInt(s.substring(i - 1, i + 1));
            if (val >= 10 && val <= 26) {
                current += two; // current num can be combined with last
            }
            two = one;
            one = current;

        }
        return one;

    }

    public static void main(String[] args) {
        String s = "1043";
        System.out.println(waysToDecode(s));
    }
}
