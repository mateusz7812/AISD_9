package com.company;

import java.util.ArrayList;
import java.util.Random;

public class QueryGenerator {
    Random r = new Random();

    String[] wordArray;

    public QueryGenerator(String[] words) {
        wordArray = words;
    }

    public String[] Generate(int amount) {
        var generated = new ArrayList<String>();

        for (int i = 0; i < amount; i++) {
            var index = r.nextInt(wordArray.length);
            generated.add(wordArray[index]);
        }

        return generated.toArray(new String[0]);
    }
}
