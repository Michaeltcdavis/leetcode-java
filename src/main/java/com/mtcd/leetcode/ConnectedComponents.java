package com.mtcd.leetcode;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
import com.google.common.collect.Sets;

import java.util.Set;

public class ConnectedComponents {

    /**
     * Computes the number of connected components from a number of nodes and an array of integers representing nodes connected by an edge.
     * @param n The number of nodes
     * @param edges An array of edges, where int[i] = [ai, bi]
     * @return The number of connected nodes
     */
    public static int connectedComponents(int n, int[][] edges) {
        Multimap<Integer, Integer> graph = ArrayListMultimap.create();
        for (int[] edge : edges) {
            int from = edge[0];
            int to = edge[1];
            graph.get(from).add(to);
            graph.get(to).add(from);
        }

        int components = 0;
        Set<Integer> seen = Sets.newHashSet();
        for (Integer i : graph.keySet()) {
            if (seen.contains(i))
                continue;

            components++;
            seeConnected(i, graph, seen);
        }
        return components + n - seen.size();
    }

    private static void seeConnected(int node, Multimap<Integer, Integer> graph, Set<Integer> seen) {
        if (seen.contains(node))
            return;

        seen.add(node);
        for (Integer neighbour : graph.get(node))
            seeConnected(neighbour, graph, seen);
    }

    public static void main(String[] args) {
        int[][] input = new int[][]{{0,1},{0,2}, {3,4},{5,6}};
        System.out.println(connectedComponents(8, input));
    }
}
