package org.solutions.findvalidwords.externalapi;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 *  For brevity, This class is assumed as a third party api which we call to check whether the given word is valid or
 *  not.
 *@see <a href="https://www.rd.com/article/longest-word-english/">LONGEST_ENGLISH_WORD_LENGTH</a>
 *
 */
public class DictionaryApi {

    public static final int LONGEST_ENGLISH_WORD_LENGTH = 45;

    private static final Set<String> dictionary = new HashSet<>(Arrays.asList("This", "his", "is", "a",
            "good", "day", "odd", "ago", "go"));

    public static boolean isValidWord(String word) {
        return dictionary.stream().anyMatch(s -> s.equalsIgnoreCase(word));
    }

    public static Set<String> getDictionaryWords() {
        return dictionary;
    }
}
