package ru.job4j.stream;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class MinMethod {
    public static String min(List<String> list) {
        Optional<String> rsl = list.stream().min(Comparator.comparingInt(String::length));
        return rsl.orElse("");
    }
}
