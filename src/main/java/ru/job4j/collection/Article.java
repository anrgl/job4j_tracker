package ru.job4j.collection;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Article {
    public static boolean generateBy(String origin, String line) {
        Set<String> words = new HashSet<>(Arrays.asList(line.split(" ")));
        for (String word : words) {
            if (!origin.contains(word)) {
                return false;
            }
        }
        return true;
    }
}
