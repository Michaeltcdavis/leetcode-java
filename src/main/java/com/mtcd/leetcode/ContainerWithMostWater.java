package com.mtcd.leetcode;


public class ContainerWithMostWater {

    public static int maxWaterVolume(int[] height) {
        //A = h * w (shortest)
        int max = 0;
        for (int i = 0; i < height.length - 1; i++) {
            int maxWidth = height.length - i;
            if ((maxWidth * height[i]) < max)
                continue;
            for (int j = i + 1; j < height.length; j++) {
                int h = Math.min(height[i], height[j]) * (j - i);
                if (h > max)
                    max = h;
            }
        }
        return max;
    }

    public static int maxWaterVolumePointers(int[] height) {
        int max = 0;
        int left = 0;
        int right = height.length - 1;
        while (right > left) {
            int a = Math.min(height[right], height[left]) * (right - left);

            max = Math.max(max, a);

            if (height[right] > height[left])
                left++;
            else
                right--;
        }
        return max;
    }

    public static void main(String[] args) {
        int[] input = new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(maxWaterVolumePointers(input));
    }
}
