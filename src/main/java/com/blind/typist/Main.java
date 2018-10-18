package com.blind.typist;

import com.blind.typist.input.SentenceObserver;
import com.blind.typist.input.TextObserver;
import com.blind.typist.input.form.MyTextBox;

public class Main {

    public static void main(String[] args) {
        TextObserver textObserver = new SentenceObserver();
        MyTextBox textBox = new MyTextBox(textObserver);
    }

}
