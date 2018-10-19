package com.blind.typist.dictionary;

import java.io.IOException;

public interface WordFinder {

    Word findWord(String word) throws RuntimeException, IOException;

}
