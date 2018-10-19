package com.blind.typist.dictionary;

import java.util.Set;

public class LocalWordFinder implements WordFinder {

    private Set<Word> words;

    public LocalWordFinder(Set<Word> words) {
        this.words = words;
    }

    @Override
    public Word findWord(String word) throws RuntimeException {
        return words.stream().filter(w -> w.getName().equals(word)).findFirst()
                .orElseThrow(() -> new RuntimeException("'" + word + "' not found"));
    }
}
