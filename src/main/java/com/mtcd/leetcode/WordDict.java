package com.mtcd.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class WordDict {

    /**
     * Provided a word and an array of dictionary words, returns true if the
     * word can be broken down into combinations of the dictionary words with
     * no letters remaining. Dictionary words can be used twice
     *
     * @param word  word to be broken down
     * @param dicts words which may comprise the compound word
     * @return true if the word can be broken down, otherwise false
     */
    public static boolean isBreakableWordByDict(String word, String[] dicts) {
        // create an array length word + 1 representing the word break of
        // each iterating length of string (ex "", "e", "es", "esp", espn")
        // store a true variable at locations where the entire string so far
        // can be broken into dicts
        // only check new new iterations from true + 1 indices (including
        // whole string so far)

        boolean[] cache = new boolean[word.length() + 1];
        cache[0] = true;

        Set<String> dictionary = new HashSet<>(Arrays.asList(dicts));

        for (int i = 0; i < word.length(); i++) {
            for (int j = 0; j <= i; j++) {
                if (cache[j] = true)
                    if (dictionary.contains(word.substring(j, i + 1)))
                        cache[i + 1] = true;
            }
        }
        return cache[word.length()];
    }

    public static void main(String[] args) {
        System.out.println(isBreakableWordByDict("espn", new String[]{"e",
                "sp", "n"}));
    }
}
