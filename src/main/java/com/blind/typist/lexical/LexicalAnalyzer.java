package com.blind.typist.lexical;

import com.blind.typist.dictionary.WordFinder;

import java.io.IOException;
import java.util.List;

public class LexicalAnalyzer implements LexicalAnalysis {

    private WordFinder wordFinder;

    public LexicalAnalyzer(WordFinder wf) {
        this.wordFinder = wf;
    }

    @Override
    public void process(List<String> words) {
        words.forEach(c -> {
            if(!c.equals(".")) {
                try {
                    System.out.println(wordFinder.findClass(c));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

//                    throw new RuntimeException("Lexical analysis error with word '" + s + "'");
    }
}
