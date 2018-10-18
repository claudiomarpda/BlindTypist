package com.blind.typist.input.form;

import com.blind.typist.input.TextObserver;

import javax.swing.*;
import java.awt.event.*;

public class MyTextBox {
    private JTextArea textArea;
    private JPanel panel;

    public MyTextBox(TextObserver textObserver) {
        textArea.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent keyEvent) {
                if(keyEvent.getKeyChar() == '\n') {
                    textObserver.notify(textArea.getText());
                }
            }
        });

        JFrame frame = new JFrame("Blind Typist");
        frame.setContentPane(panel);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setSize(500, 250);
        frame.setLocationRelativeTo(null);
    }

}
