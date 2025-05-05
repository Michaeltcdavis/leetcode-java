package com.mtcd.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WaterFlow {

    public static List<List<Integer>> flowToBothOceans(int[][] topograph) {
        int height = topograph.length;
        int width = topograph[0].length;

        //Pacific Drainers
        boolean[][] pacificDrainers =
                new boolean[height][width];
        Arrays.fill(pacificDrainers[0], true);
        for (boolean[] row : pacificDrainers) {
            row[0] = true;
        }
        for (int i = 1; i < height; i++) {
            for (int j = 1; j < width; j++) {
                int topo = topograph[i][j];
                int upper = topograph[i - 1][j];
                int left = topograph[i][j - 1];
                if (topo > upper && pacificDrainers[i - 1][j])
                    pacificDrainers[i][j] = true;
                if (topo > left && pacificDrainers[i][j - 1])
                    pacificDrainers[i][j] = true;
            }
        }

        //Atlantic Drainers
        boolean[][] atlanticDrainers = new boolean[height][width];
        Arrays.fill(atlanticDrainers[height - 1], true);
        for (boolean[] row : atlanticDrainers) {
            row[width - 1] = true;
        }
        for (int i = height - 2; i >= 0; i--) {
            for (int j = width - 2; j >= 0; j--) {
                int topo = topograph[i][j];
                int lower = topograph[i + 1][j];
                int right = topograph[i][j + 1];
                if (topo > lower && atlanticDrainers[i + 1][j])
                    atlanticDrainers[i][j] = true;
                if (topo > right && atlanticDrainers[i][j + 1])
                    atlanticDrainers[i][j] = true;
            }
        }
        // Pacific and Atlantic Drainers
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (pacificDrainers[i][j] && atlanticDrainers[i][j]) {
                    result.add(List.of(i, j));
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] row1 = new int[]{1, 2, 2, 3, 5};
        int[] row2 = new int[]{3, 2, 3, 4, 4,};
        int[] row3 = new int[]{2, 4, 5, 3, 1};
        int[] row4 = new int[]{6, 7, 1, 4, 5};
        int[] row5 = new int[]{5, 1, 1, 2, 4};
        int[][] input = new int[][]{row1, row2, row3, row4, row5};
        List<List<Integer>> result = flowToBothOceans(input);
        for (List<Integer> coord : result) {
            System.out.println(coord.get(0) + ", " + coord.get(1));
        }

    }
}
