package com.blind.typist.lexical;

import com.blind.typist.dictionary.WordClassification;
import com.blind.typist.dictionary.WordFinder;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static com.blind.typist.dictionary.WordClassification.DOT;
import static com.blind.typist.dictionary.WordClassification.UNDEFINED;

public class LexicalAnalyzer implements LexicalAnalysis {

    private WordFinder wordFinder;
    private List<Token> tokens;

    public LexicalAnalyzer(WordFinder wf) {
        this.wordFinder = wf;
        tokens = new ArrayList<>();

    }

    @Override
    public void analyze(List<String> words) {
        List<String> results = new ArrayList<>();

        words.forEach(c -> {
            if (!c.equals(".")) {
                try {
                    String result = wordFinder.findClass(c);
                    Token token = new Token(c, classify(result));
                    tokens.add(token);

                    System.out.println(token);

                } catch (RuntimeException | IOException e) {
                    results.add("Invalid word '" + c + "'");
                }
            } else {
                tokens.add(new Token(".", DOT));
            }
        });
        results.forEach(System.out::println);
        results.clear();
    }

    private WordClassification classify(String classification) {
        for (WordClassification w : WordClassification.values()) {
            if (w.toString().equals(classification)) {
                return w;
            }
        }
        return UNDEFINED;
    }
}
