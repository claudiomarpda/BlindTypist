package com.blind.typist.lexical;

import com.blind.typist.dictionary.WordClassification;

public class Token {

    private String word;
    private WordClassification classification;

    public Token(String word, WordClassification classification) {
        this.word = word;
        this.classification = classification;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public WordClassification getClassification() {
        return classification;
    }

    public void setClassification(WordClassification classification) {
        this.classification = classification;
    }

    @Override
    public String toString() {
        return "Token{" +
                "word='" + word + '\'' +
                ", classification=" + classification +
                '}';
    }
}
