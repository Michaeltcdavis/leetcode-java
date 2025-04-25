package com.mtcd.leetcode;

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

        for (int i = 0; i < word.length(); i++) {
            for (int j = 0; j <= i; j++) {
                if (cache[j] = true)
                    for (String dict : dicts) {
                        if (subStringMatches(word, j + 1, i + 1, dict)) {
                            cache[i + 1] = true;
                        }
                    }
            }
        }
        return cache[word.length()];
    }

    private static boolean subStringMatches(String superString, int start,
                                            int end,
                                            String substring) {
        if (substring.length() != end - start)
            return false;

        for (int i = start; i < end; i++) {
            if (superString.charAt((i)) != substring.charAt(i - start))
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isBreakableWordByDict("espn", new String[]{"e",
                "sp", "n"}));
    }
}
