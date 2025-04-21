package com.mtcd.leetcode;

public class StockProfit {

    /**
     * Takes an array of daily stock price values and returns the largest
     * profit that can be made by buying on one day and selling on another day.
     *
     * @param dailyValues
     * @return The maximum profit that can be made
     */
    public static int maxProfit(int[] dailyValues) {
        int buy = dailyValues[0];
        int maxProfit = 0;
        for (int val : dailyValues) {
            if (val < buy)
                buy = val;

            maxProfit = Math.max(maxProfit, val - buy);
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        int[] dailies = new int[]{7, 1, 5, 3, 6, 4};
        System.out.println(maxProfit(dailies));
    }
}
