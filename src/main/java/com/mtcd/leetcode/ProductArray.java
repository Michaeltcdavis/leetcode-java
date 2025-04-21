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

        int[] posts = new int[s];
        posts[posts.length - 1] = 1;

        for (int i = 1; i < s; i++) {
            pres[i] = ints[i - 1] * pres[i - 1];
        }
        for (int i = s - 2; i >= 0; i--) {
            posts[i] = ints[i + 1] * posts[i + 1];
        }

        int[] result = new int[s];
        for (int i = 0; i < ints.length; i++) {
            result[i] = pres[i] * posts[i];
            System.out.println(i + ", " + pres[i] + ", " + posts[i]);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] ints = new int[]{1, 2, 3, 4};
        int[] result = arrayProductExceptSelf(ints);
        for (int i : result) {
            System.out.println(i);
        }
    }
}
