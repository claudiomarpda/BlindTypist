package com.blind.typist;

import com.blind.typist.dictionary.LocalWordFinder;
import com.blind.typist.dictionary.Word;
import com.blind.typist.input.SentenceObserver;
import com.blind.typist.input.TextObserver;
import com.blind.typist.input.form.MyTextBox;
import com.blind.typist.lexical.LexicalAnalysis;
import com.blind.typist.lexical.LexicalAnalyzer;
import com.blind.typist.util.FileUtil;

import java.io.IOException;
import java.util.Set;

public class Main {

    public static void main(String[] args) throws IOException {
        final Set<Word> dictionary = FileUtil.readAll();
        dictionary.forEach(System.out::println);

        LexicalAnalysis la = new LexicalAnalyzer(new LocalWordFinder(dictionary));
        TextObserver textObserver = new SentenceObserver(la);

        new MyTextBox(textObserver);

    }

}
