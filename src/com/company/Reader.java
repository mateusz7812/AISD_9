package com.company;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class Reader {
    public String[] ReadWordsFromFile(String fileName) throws IOException {
        var programPath = new File(".").getCanonicalPath();
        var readerFolder = programPath + "\\src\\readerFiles\\";
        var filePath = readerFolder + fileName;
        var file = new File(filePath);
        var bufferedReader = new BufferedReader(new FileReader(file));
        String[] wordsArray = bufferedReader.lines()
                .map(line -> line.split(" "))
                .flatMap(Arrays::stream)
                .filter(word -> !word.equals(""))
                .toArray(String[]::new);
        return wordsArray;
    }
}
