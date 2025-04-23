package com.mtcd.leetcode;

import java.util.Arrays;

public class CoinChange {

    public static int leastCoinsUsed(int[] coinValues, int total) {
        int[] amt = new int[total + 1];
        Arrays.fill(amt, total + 1);
        amt[0] = 0;
        for (int i = 1; i <= total; i++) {
            for (int val : coinValues) {
                if (i - val < 0)
                    continue;
                else
                    amt[i] = Math.min(amt[i], 1 + amt[i - val]);
            }
        }
        return amt[total] == (total + 1) ? -1 : amt[total];
    }

    public static void main(String[] args) {
        int[] coinValues = new int[]{1, 3, 5, 6};
        System.out.println(leastCoinsUsed(coinValues, 8));
    }
}
