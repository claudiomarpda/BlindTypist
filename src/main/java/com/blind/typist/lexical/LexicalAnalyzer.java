package com.blind.typist.lexical;

import com.blind.typist.dictionary.Classification;
import com.blind.typist.dictionary.Word;
import com.blind.typist.dictionary.WordFinder;
import com.blind.typist.syntactic.SyntacticAnalyzer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static com.blind.typist.dictionary.Classification.DOT;
import static com.blind.typist.dictionary.Classification.UNDEFINED;

public class LexicalAnalyzer implements LexicalAnalysis {

    private WordFinder wordFinder;
    private List<Token> tokens;

    public LexicalAnalyzer(WordFinder wf) {
        this.wordFinder = wf;
        tokens = new ArrayList<>();
    }

    @Override
    public void analyze(List<String> words) {
        System.out.println("----------------");
        System.out.println("\nLexical analysis\n");

        List<String> results = new ArrayList<>();

        words.forEach(c -> {
            if (!c.equals(".")) {
                try {
                    Word result = wordFinder.findWord(c);
                    Token token = new Token(result);
                    tokens.add(token);

                    System.out.println(token);

                } catch (RuntimeException | IOException e) {
                    results.add("Invalid word '" + c + "'");
                }
            } else {
                Word w = new Word(".", DOT.toString(), "", "");
                tokens.add(new Token(w));
            }
        });
        results.forEach(System.out::println);
        results.clear();

        new SyntacticAnalyzer(tokens).analyze();
    }

    private Classification classify(String classification) {
        for (Classification w : Classification.values()) {
            if (w.toString().equals(classification)) {
                return w;
            }
        }
        return UNDEFINED;
    }
}
