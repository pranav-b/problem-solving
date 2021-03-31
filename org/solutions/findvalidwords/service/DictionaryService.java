package org.solutions.findvalidwords.service;

import org.solutions.findvalidwords.externalapi.DictionaryApi;

public class DictionaryService {

    public boolean isValidWord(String word) {
        return DictionaryApi.isValidWord(word);
    }
}
