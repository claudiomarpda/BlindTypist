package com.blind.typist.dictionary;

import java.io.IOException;

public interface WordFinder {

    String findClass(String word) throws RuntimeException, IOException;

}
