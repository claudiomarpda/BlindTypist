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

            // Analyze sentence
            lexicalAnalysis.analyze(wordList);
        }
    }
}
