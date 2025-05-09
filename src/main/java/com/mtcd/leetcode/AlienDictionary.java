package com.mtcd.leetcode;

import java.util.*;

public class AlienDictionary {

    public static String lexicographicalLetters(String[] words) {
        // add all letters to a hashmap of letter 2 lesser chars
        // for each word
        //     add first unequal chars to hashmap dependencies
        //     dfs through hashmap to
        //           add char if no lessers
        //           add char if lessers have been added
        //           otherwise return false
        // if added,

        HashMap<Character, List<Character>> letter2lesser = new HashMap<>();
        for (String word : words) {
            for (char c : word.toCharArray()) {
                letter2lesser.putIfAbsent(c, new ArrayList<>());
            }
        }

        for (int i = 0; i < words.length - 1; i++) {
            String w1 = words[i];
            String w2 = words[i + 1];
            for (int j = 0; j < w1.length() && j < w2.length(); j++) {
                if (w2.charAt(j) != w1.charAt(j)) {
                    letter2lesser.get(w2.charAt(j)).add(w1.charAt(j));
                    break;
                }
            }
        }

        Set<Character> letters = letter2lesser.keySet();
        Map<Character, Boolean> visited = new HashMap<>();
        StringBuilder result = new StringBuilder();
        for (Character c : letters) {
            boolean res = dfs(c, result, letter2lesser, visited);
            if (!res)
                return "";
        }
        return result.toString();
    }

    private static boolean dfs(Character c, StringBuilder result,
                               Map<Character, List<Character>> letter2lesser,
                               Map<Character, Boolean> visited) {
        if (visited.containsKey(c))
            return visited.get(c);

        visited.put(c, false);

        for (Character lesser : letter2lesser.get(c)) {
            boolean added = dfs(lesser, result, letter2lesser, visited);
            if (!added)
                return false;
        }
        result.append(c);
        visited.put(c, true);
        return true;

    }

    public static void main(String[] args) {
        String[] input = new String[]{"wrt", "wrf", "er", "ett", "rftt"};
        System.out.println(lexicographicalLetters(input));
    }
}
