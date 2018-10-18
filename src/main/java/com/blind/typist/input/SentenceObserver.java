package com.blind.typist.input;

import com.blind.typist.lexical.LexicalAnalysis;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SentenceObserver implements TextObserver {

    private LexicalAnalysis lexicalAnalysis;

    public SentenceObserver(LexicalAnalysis la) {
        this.lexicalAnalysis = la;
    }

    @Override
    public void notify(String text) {

        String[] sentences = text.split("\n");

        for (int i = 0; i < sentences.length; i++) {

            String[] words = sentences[i].split(" ");
            List<String> wordList = new ArrayList<>(Arrays.asList(words));

            // Last word must be a dot: .
            // Get last word
            String last = wordList.remove(wordList.size() - 1);

            // Separate word from dot: word .
            String w = last.substring(0, last.length() - 1);
            String dot = last.substring(last.length() - 1);

            // Add to list
            wordList.add(w);
            wordList.add(dot);

            // Analyze sentence
            lexicalAnalysis.process(wordList);
        }
    }
}
