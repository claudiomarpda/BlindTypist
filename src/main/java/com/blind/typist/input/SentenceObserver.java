package com.blind.typist.input;

import java.util.ArrayList;
import java.util.Arrays;

public class SentenceObserver implements TextObserver {

    private ArrayList<String> sentences;

    public SentenceObserver() {
        sentences = new ArrayList<>();
    }

    @Override
    public void notify(String text) {
        sentences.addAll(Arrays.asList(text.split("\n")));
        sentences.forEach(System.out::println);
        sentences.clear();
    }
}
