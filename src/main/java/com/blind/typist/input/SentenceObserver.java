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

        for (String sentence : sentences) {

            String[] words = sentence.split(" ");
            List<String> wordList = new ArrayList<>(Arrays.asList(words));

            if(wordList.get(wordList.size() -1).equals(".")) {
                // Last word must be a dot: .
                // Get last word
                String last = wordList.remove(wordList.size() - 1);

                // Separate word from dot: word .
                String w = last.substring(0, last.length() - 1);
                String dot = last.substring(last.length() - 1);

                // Add both to list
                wordList.add(w);
                wordList.add(dot);
            }

            // Analyze sentence
            lexicalAnalysis.process(wordList);
        }
    }
}
