package com.mtcd.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Stack;

public class GraphValidTree {
    /**
     * This method determines whether a list of graph edges represents a valid
     * tree
     *
     * @param n     the number of nodes in the graph
     * @param edges the links between nodes numbered 0 through n - 1
     * @return true if the edges represent a valid tree, false otherwise
     */
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
        if (edges.length != n - 1)
            return false;

        List<List<Integer>> adjacency = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjacency.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            adjacency.get(edge[0]).add(edge[1]);
            adjacency.get(edge[1]).add(edge[0]);
        }
        Stack<Integer> path = new Stack<>();
        HashSet<Integer> visited = new HashSet<>();

        path.push(0);
        visited.add(0);

        while (!path.isEmpty()) {
            Integer node = path.pop();
            for (Integer neighbour : adjacency.get(node)) {
                if (visited.contains(neighbour))
                    continue;
                visited.add(neighbour);
                path.push(neighbour);
            }
        }
        return visited.size() == n;
    }

    public static void main(String[] args) {
        int[][] input = new int[][]{{0, 1}, {1, 2}, {0, 3}};
        System.out.println(isValidTreeGT(4, input));
    }
}
