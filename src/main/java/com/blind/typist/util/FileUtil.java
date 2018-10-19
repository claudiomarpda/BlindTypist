package com.blind.typist.util;

import com.blind.typist.dictionary.Word;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FileUtil {

    private static String readFileAsString(String fullPath) throws IOException {
        return new String(Files.readAllBytes(Paths.get(fullPath)));
    }

    public static List<Word> read(String fullPath) throws IOException {
        String text = readFileAsString(fullPath);

        List<Word> words = new ArrayList<>();

        String[] lines = text.split("\n");
        for (String line : lines) {
            String[] columns = line.split(",");

            if(columns.length == 4) {
                words.add(new Word(columns[0], columns[1], columns[2], columns[3]));
            }
            else {
                words.add(new Word(columns[0], columns[1], columns[2]));
            }
        }
        return words;
    }

    public static List<Word> readAll() throws IOException {
        List<Word> words = new ArrayList<>();

        words.addAll(read("src/main/resources/artigos.csv"));
        words.addAll(read("src/main/resources/substantivos.csv"));
        words.addAll(read("src/main/resources/verbos.csv"));
        words.addAll(read("src/main/resources/adjetivos.csv"));

        return words;
    }
}
