package com.company;

import com.company.BinarySearchTree.BinarySearchTree;
import com.company.Comparator.StringComparator;
import com.company.Timers.Timer;

import java.io.IOException;
import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;
import java.util.Arrays;
import java.util.HashMap;

public class Main {
    private static Timer timer = new Timer();
    private static Reader reader = new Reader();
    private static HashMap<String, Duration> storageSystemWithDuration = new HashMap<>();
    private static String[] allWords;
    private static String[] selectedWords;

    public static void main(String[] args) {
        ReadWords("kzyzacy.txt");
        if (allWords == null) return;

        SelectStrings(3000);

        BstTest();
        ListTest();

        PrintResults();
    }

    private static void ListTest() {
        var list = Arrays.asList(allWords);
        Duration duration = timer.TimeOperation(() -> {
            for (String word :
                    selectedWords) {
                list.indexOf(word);
            }
        });
        storageSystemWithDuration.put("List", duration);
    }

    private static void BstTest() {
        var bst = new BinarySearchTree<>(new StringComparator());
        bst.AddRange(allWords);
        Duration duration = timer.TimeOperation(() -> {
            for (String word :
                    selectedWords) {
                bst.Get(word);
            }
        });
        storageSystemWithDuration.put("Binary Search Tree", duration);
    }

    private static void PrintResults() {
        System.out.printf("All elements: %s\n", allWords.length);
        System.out.printf("Search elements: %s\n", selectedWords.length);
        for (var pair :
                storageSystemWithDuration.entrySet()) {
            System.out.printf("%s => %s%s \n", pair.getKey(), pair.getValue().toMillis(), " ms");
        }
    }

    private static void SelectStrings(int amount) {
        var generator = new QueryGenerator(allWords);
        selectedWords = generator.Generate(amount);
    }

    private static void ReadWords(String fileName) {
        try {
            allWords = reader.ReadWordsFromFile(fileName);
        } catch (IOException e) {
            System.out.println("Wystapil problem z wczytaniem pliku");
        }
    }
}
