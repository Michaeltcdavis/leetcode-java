package com.mtcd.leetcode;

public class ProductArray {
    /**
     * returns an array representing the product of all values in the
     * input array except the current value. Done without using the divide
     * operation with time complexity O(n)
     *
     * @param ints The input array
     * @return The array of products
     */
    public static int[] arrayProductExceptSelf(int[] ints) {
        int s = ints.length;

        int[] pres = new int[s];
        pres[0] = 1;

        for (int i = 1; i < s; i++) {
            pres[i] = ints[i - 1] * pres[i - 1];
        }

        int post = 1;
        for (int i = s - 1; i >= 0; i--) {
            pres[i] = pres[i] * post;
            post = post * ints[i];
        }
        return pres;
    }

    public static void main(String[] args) {
        int[] ints = new int[]{1, 2, 3, 4};
        int[] result = arrayProductExceptSelf(ints);
        for (int i : result) {
            System.out.println(i);
        }
    }
}
