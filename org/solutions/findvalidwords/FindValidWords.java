package org.solutions.findvalidwords;

import org.solutions.findvalidwords.externalapi.DictionaryApi;
import org.solutions.findvalidwords.service.WordCheckerService;
import org.solutions.findvalidwords.service.DictionaryService;

import java.util.HashSet;
import java.util.Set;

/**
 * <p>
 * Problem:
 * Consider a input text dataset without any spaces between the words.
 * Solution needs to find all the valid words from the dataset.
 * </p>
 * <p>
 * Assumptions made:
 * Dictionary API is available which can confirm whether the given word is valid.
 * (I have implemented it case-insensitively)
 *</p>
 * <p>
 * Time Complexity:
 *
 * Initially time complexity of the program was O(n^2).
 * But I have added  a check of @see {@link DictionaryApi#LONGEST_ENGLISH_WORD_LENGTH} to reduce the
 * time complexity to o (n * L) where L is the size of LONGEST_ENGLISH_WORD_LENGTH
 * </p>
 */
public class FindValidWords {

    public static void main(String[] args) {
        DictionaryService dictionaryService = new DictionaryService();
        System.out.println("Dictionary :" + DictionaryApi.getDictionaryWords());
        System.out.println();
        String text = "thisisagoodday";
        String text1 = "thisisaday";
        showValidWords(dictionaryService, text);
        showValidWords(dictionaryService, text1);
    }

    private static void showValidWords(DictionaryService dictionaryService, String text) {
        System.out.println("----------Start---------------");
        System.out.println("Input data set:" + text);
        Set<String> validWords = findValidWords(dictionaryService, text);
        System.out.println("\nValid words fom the data set are:" + validWords);
        System.out.println("-----------End--------------");
        System.out.println();
    }

    private static Set<String> findValidWords(DictionaryService dictionaryService, String text) {
        Set<String> validWords = new HashSet<>();
        for (int i = 0; i < text.length(); i++) {
            for (int j = i + 1; j <= text.length(); j++) {
                String subset = text.substring(i, j);
                if (subset.length() > DictionaryApi.LONGEST_ENGLISH_WORD_LENGTH) {
                    break;
                } else {
                    if(WordCheckerService.validWordPossible(subset)) {
                        if (dictionaryService.isValidWord(subset)) {
                            validWords.add(subset);
                        }
                    }
                }
            }
        }
        return validWords;
    }
}

