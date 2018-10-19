package com.blind.typist.lexical;

import com.blind.typist.dictionary.Word;

public class Token {

    private Word word;

    public Token(Word word) {
        this.word = word;
    }

    public Word getWord() {
        return word;
    }

    public void setWord(Word word) {
        this.word = word;
    }

    @Override
    public String toString() {
        return "Token{" +
                "word=" + word +
                '}';
    }
}
