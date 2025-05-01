package com.mtcd.leetcode;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Connected Graph: graph where all nodes are accessible from any other node
 * through node traversal
 * Deep Copy: Different nodes with same node values
 */
public class CloneGraph {

    /**
     * Given a reference to one node in a graph, returns a deep copy of the
     * entire connected graph.
     * Time Complexity O(e + v) where:
     * e is number of edges
     * v is number of vertices
     *
     * @param first The first node in the connected graph to be copied.
     * @return a collection of nodes copied from the original graph
     */
    public static Node cloneGraph(Node node) {
        if (node == null)
            return null;
        Map<Node, Node> node2clone = new HashMap<>();

        return cloneNode(node, node2clone);

    }

    private static Node cloneNode(Node node, Map<Node, Node> node2clone) {
        if (node2clone.containsKey(node))
            return node2clone.get(node);

        Node clone = new Node(node.val, new ArrayList<>());
        node2clone.put(node, clone);

        for (Node neighbour : node.neighbours) {
            clone.neighbours.add(cloneNode(neighbour, node2clone));
        }

        return clone;
    }

    public static void main(String[] args) {
        Node one = new Node(1, new ArrayList<>());
        Node two = new Node(2, new ArrayList<>());
        Node three = new Node(3, new ArrayList<>());
        one.neighbours.add(two);
        one.neighbours.add(three);
        two.neighbours.add(three);
        two.neighbours.add(one);
        three.neighbours.add(one);
        three.neighbours.add(two);
        Node result = cloneGraph(one);
        printNode(result, new HashSet<>());
    }

    private static void printNode(Node node, Set<Node> printed) {
        if (printed.contains(node))
            return;


        System.out.println(node.print());
        printed.add(node);

        for (Node neighbour : node.neighbours) {
            printNode(neighbour, printed);
        }
    }

    private static class Node {
        public int val;
        public List<Node> neighbours;

        public Node(int val, List<Node> neighbours) {
            this.val = val;
            this.neighbours = neighbours;
        }

        public String print() {
            return "val: " + val + ", neighbours: " + print(neighbours);
        }

        private String print(List<Node> neighbours) {
            return "[" + neighbours.stream()
                    .map(n -> String.valueOf(n.val))
                    .collect(Collectors.joining(",")) + "]";
        }
    }
}
