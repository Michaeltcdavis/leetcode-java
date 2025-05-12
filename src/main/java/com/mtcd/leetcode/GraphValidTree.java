package com.mtcd.leetcode;

import java.util.HashSet;

public class GraphValidTree {

    public static boolean isValidTree(int n, int[][] edges) {
        // init hashmap
        // for each edge, check if child edge exists in map as key
        //        if key exists and child is other than parent node, return
        //        false (loop)
        // dfs on hashmap to see if you can reach the edge (need visited set)
        // Space: O(v+e)
        // Space: O(v+e)
        return false;
    }

    public static boolean isValidTreeGT(int n, int[][] edges) {
        // in a tree, num of edges is num of nodes - 1, all nodes are connected
        // add all ints in edges to a set
        // confirm set is size n
        // confirm edges length is n - edges
        HashSet<Integer> nodes = new HashSet<>();
        for (int[] edge : edges) {
            nodes.add(edge[0]);
            nodes.add(edge[1]);
        }
        if (nodes.size() != n)
            return false;

        if (edges.length != n - 1)
            return false;
        return true;
    }

    public static void main(String[] args) {
        int[][] input = new int[][]{{0, 1}, {1, 2}, {0, 2}};
        System.out.println(isValidTreeGT(4, input));
    }
}
