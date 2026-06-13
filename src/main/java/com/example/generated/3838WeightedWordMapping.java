package com.example.generated;

public class 3838WeightedWordMapping {

    /**
     * 
     * @param words
     * @param weights
     * @return
     * 
     * TIME COMPLEXITY: O(n * m) where n is the number of words and m is the maximum length of a word
     * SPACE COMPLEXITY: O(n) where n is the number of words
     */
    public static String solve(String[] words, int[] weights) {
        if (words == null || words.length == 0 || weights == null || weights.length != 26) {
            throw new IllegalArgumentException("Invalid input");
        }

        StringBuilder result = new StringBuilder();
        for (String word : words) {
            if (word == null || word.length() == 0 || word.length() > 10) {
                throw new IllegalArgumentException("Invalid word");
            }

            int weight = 0;
            for (char c : word.toCharArray()) {
                int index = c - 'a';
                if (index < 0 || index >= 26) {
                    throw new IllegalArgumentException("Invalid character in word");
                }
                if (weights[index] < 1 || weights[index] > 100) {
                    throw new IllegalArgumentException("Invalid weight");
                }
                weight += weights[index];
            }

            int mappedIndex = (26 - (weight % 26)) % 26;
            char mappedChar = (char) ('a' + mappedIndex);
            result.append(mappedChar);
        }

        return result.toString();
    }

    public static void main(String[] args) {
        String[] words1 = {"abcd", "def", "xyz"};
        int[] weights1 = {5, 3, 12, 14, 1, 2, 3, 2, 10, 6, 6, 9, 7, 8, 7, 10, 8, 9, 6, 9, 9, 8, 3, 7, 7, 2};
        System.out.println(solve(words1, weights1)); // "rij"

        String[] words2 = {"a", "b", "c"};
        int[] weights2 = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
        System.out.println(solve(words2, weights2)); // "yyy"

        String[] words3 = {"abcd"};
        int[] weights3 = {7, 5, 3, 4, 3, 5, 4, 9, 4, 2, 2, 7, 10, 2, 5, 10, 6, 1, 2, 2, 4, 1, 3, 4, 4, 5};
        System.out.println(solve(words3, weights3)); // "g"
    }
}