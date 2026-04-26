package com.mtcd.leetcode;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertTrue;

class InsertIntervalTest {

    private static void assertIntervalsEqual(int[][] expected, int[][] actual) {
        assertTrue(
                Arrays.deepEquals(expected, actual),
                () -> "Expected: " + Arrays.deepToString(expected) + ", but got: " + Arrays.deepToString(actual)
        );
    }

    @Test
    void insertsAndMergesInMiddle() {
        int[][] intervals = {{1, 3}, {6, 9}};
        int[] newInterval = {2, 5};

        int[][] actual = InsertInterval.insert(intervals, newInterval);

        int[][] expected = {{1, 5}, {6, 9}};
        assertIntervalsEqual(expected, actual);
    }

    @Test
    void mergesAcrossMultipleIntervals() {
        int[][] intervals = {{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}};
        int[] newInterval = {4, 8};

        int[][] actual = InsertInterval.insert(intervals, newInterval);

        int[][] expected = {{1, 2}, {3, 10}, {12, 16}};
        assertIntervalsEqual(expected, actual);
    }

    @Test
    void insertsBeforeAllWithoutOverlap() {
        int[][] intervals = {{3, 5}, {7, 9}};
        int[] newInterval = {1, 2};

        int[][] actual = InsertInterval.insert(intervals, newInterval);

        int[][] expected = {{1, 2}, {3, 5}, {7, 9}};
        assertIntervalsEqual(expected, actual);
    }

    @Test
    void insertsAfterAllWithoutOverlap() {
        int[][] intervals = {{1, 2}, {3, 5}};
        int[] newInterval = {6, 7};

        int[][] actual = InsertInterval.insert(intervals, newInterval);

        int[][] expected = {{1, 2}, {3, 5}, {6, 7}};
        assertIntervalsEqual(expected, actual);
    }

    @Test
    void emptyIntervalsReturnsNewIntervalOnly() {
        int[][] intervals = {};
        int[] newInterval = {4, 8};

        int[][] actual = InsertInterval.insert(intervals, newInterval);

        int[][] expected = {{4, 8}};
        assertIntervalsEqual(expected, actual);
    }

    @Test
    void newIntervalCoversAllExisting() {
        int[][] intervals = {{2, 3}, {5, 7}};
        int[] newInterval = {1, 10};

        int[][] actual = InsertInterval.insert(intervals, newInterval);

        int[][] expected = {{1, 10}};
        assertIntervalsEqual(expected, actual);
    }
}