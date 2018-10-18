package com.blind.typist.lexical;

import java.util.List;

public class LexicalAnalyzer implements LexicalAnalysis {

    @Override
    public void process(List<String> words) {
        words.forEach(System.out::println);

//                    throw new RuntimeException("Lexical analysis error with word '" + s + "'");
    }
}
