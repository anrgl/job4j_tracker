package ru.job4j.collection;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Article {
    public static boolean generateBy(String origin, String line) {
        String originWithoutPunctuation = origin.replaceAll("\\p{P}", "");
        String lineWithoutPunctuation = line.replaceAll("\\p{P}", "");
        Set<String> words = new HashSet<>(Arrays.asList(lineWithoutPunctuation.split(" ")));
        for (String word : words) {
            if (!originWithoutPunctuation.contains(word)) {
                return false;
            }
        }
        return true;
    }
}
