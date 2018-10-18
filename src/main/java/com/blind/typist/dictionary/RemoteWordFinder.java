package com.blind.typist.dictionary;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class RemoteWordFinder implements WordFinder {

    private static final String PAGE_URL = "https://www.dicionarioweb.com.br/";
    private static final String LINE_START = "<abbr ";
    private static final char TARGET_START = '>';
    private static final char TARGET_END = '<'; // </abbr>


    private static String readPage(String wordName) throws IOException {
        BufferedReader br = null;
        StringBuilder sb = new StringBuilder();

        try {
            URL url = new URL(PAGE_URL + wordName);
            br = new BufferedReader(new InputStreamReader(url.openStream()));

            for (String line = br.readLine(); line != null; line = br.readLine()) {
                sb.append(line).append(System.lineSeparator());
            }
        } finally {
            if (br != null) {
                br.close();
            }
        }
        return sb.toString();
    }

    /**
     * The pattern to be handled is:
     * <abbr title="Substantivo Feminino">f.</abbr>
     */
    public String findClass(String word) throws IOException {
        String page = readPage(word);
        int patternStart = page.indexOf(LINE_START);

        if (patternStart == -1) {
            throw new RuntimeException("Word '" + word + "' not found");
        }

        int classStart = 0;
        int classEnd = 0;

        for (int i = patternStart + LINE_START.length(); i < page.length(); i++) {
            if (page.charAt(i) == TARGET_START) {
                classStart = i + 1;
            } else if (page.charAt(i) == TARGET_END) {
                classEnd = i;
                break;
            }
        }
        return page.substring(classStart, classEnd).toLowerCase();
    }

}
