package org.solutions.findvalidwords.service;

/**
 * Here, We will check  if there is possibility if the word can be valid.
 * For that purpose, we can use bloom filter here. For the brevity of the program,
 * I have kept bloom filter simple, we can tweak it later as per results.
 */
public class WordCheckerService {

    private static final int ARRAY_SIZE = 2147483;

    private static final int[] INVALID_WORD_BLOOM_FILTER = new int[ARRAY_SIZE];

    private static int hash1(String word) {
        return (2 * word.length() + 1) % ARRAY_SIZE;
    }

    private static int hash2(String word) {
        return (7 * word.length() + 13) % ARRAY_SIZE;
    }

    public static boolean validWordPossible(String subset) {
        if (BloomFilter.lookUp(subset.toLowerCase())) {
            BloomFilter.insert(subset.toLowerCase());
            return false;
        }
        return true;
    }

    private static class BloomFilter {
        public static void insert(String word) {
            int h1 = hash1(word);
            int h2 = hash2(word);
            INVALID_WORD_BLOOM_FILTER[h1] = 1;
            INVALID_WORD_BLOOM_FILTER[h2] = 1;
        }

        public static boolean lookUp(String word) {
            int h1 = hash1(word);
            int h2 = hash2(word);
            return INVALID_WORD_BLOOM_FILTER[h1] == 1 && INVALID_WORD_BLOOM_FILTER[h2] == 1;
        }
    }
}
