package com.blind.typist.lexical;

import com.blind.typist.dictionary.Word;
import com.blind.typist.dictionary.WordFinder;
import com.blind.typist.syntactic.SyntacticAnalyzer;

import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static com.blind.typist.dictionary.Classification.DOT;

public class LexicalAnalyzer implements LexicalAnalysis {

    private WordFinder wordFinder;
    private List<Token> tokens;

    public LexicalAnalyzer(WordFinder wf) {
        wordFinder = wf;
        tokens = new ArrayList<>();
    }

    @Override
    public void analyze(List<String> words) {
        System.out.println("\nLexical analysis start\n");

        List<String> results = new ArrayList<>();

        words.forEach(c -> {
            try {
                c = c.trim();
                checkWord(c);

            } catch (RuntimeException | IOException e) {
                results.add(e.getMessage());
            }
        });

        if (!results.isEmpty()) {
            Toolkit.getDefaultToolkit().beep();
        }

        results.forEach(System.out::println);

        System.out.println("\nLexical analysis end\n");

        new SyntacticAnalyzer(tokens).analyze();
        tokens.clear();
    }

    private void checkWord(String name) throws IOException {
        if (name.equals(".")) {
            Word w = new Word(".", DOT.toString());
            tokens.add(new Token(w));
            return;
        }

        char firstChar = name.charAt(0);
        char lastChar = name.charAt(name.length() - 1);
        boolean dotAtLastChar = false;

        // If first or last character is a dot (.)
        if (firstChar == '.') {
            name = name.substring(1);
            Word w = new Word(".", DOT.toString());
            tokens.add(new Token(w));
        } else if (lastChar == '.') {
            name = name.substring(0, name.length() - 1);
            dotAtLastChar = true;
        }

        Word result = wordFinder.findWord(name);
        Token token = new Token(result);
        tokens.add(token);

        if (dotAtLastChar) {
            Word w = new Word(".", DOT.toString());
            tokens.add(new Token(w));
        }

    }

}
