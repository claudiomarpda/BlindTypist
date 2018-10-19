package com.blind.typist.util;

import com.blind.typist.dictionary.Word;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
            else if(columns.length == 3) {
                words.add(new Word(columns[0], columns[1], columns[2]));
            }
            else if(columns.length == 2) {
                words.add(new Word(columns[0], columns[1]));
            }
        }
        return words;
    }

    public static Set<Word> readAll() throws IOException {
        Set<Word> words = new HashSet<>();

        words.addAll(read("src/main/resources/artigos.csv"));
        words.addAll(read("src/main/resources/substantivos.csv"));
        words.addAll(read("src/main/resources/verbos.csv"));
        words.addAll(read("src/main/resources/adjetivos.csv"));
        words.addAll(read("src/main/resources/preposicoes.csv"));

        return words;
    }
}
