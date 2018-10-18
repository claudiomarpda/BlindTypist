package com.blind.typist;

import com.blind.typist.dictionary.RemoteWordFinder;
import com.blind.typist.input.SentenceObserver;
import com.blind.typist.input.TextObserver;
import com.blind.typist.input.form.MyTextBox;
import com.blind.typist.lexical.LexicalAnalysis;
import com.blind.typist.lexical.LexicalAnalyzer;

public class Main {

    public static void main(String[] args) {
        LexicalAnalysis la = new LexicalAnalyzer(new RemoteWordFinder());
        TextObserver textObserver = new SentenceObserver(la);

        new MyTextBox(textObserver);
    }

}
