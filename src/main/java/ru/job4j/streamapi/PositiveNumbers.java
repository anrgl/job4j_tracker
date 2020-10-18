package ru.job4j.streamapi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PositiveNumbers {
    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<>(
                Arrays.asList(-5, -4, -3, -2, -1, 0, 1, 2, 3, 4, 5)
        );
        List<Integer> positiveNumbers = numbers.stream().filter(
                number -> number > -1
        ).collect(Collectors.toList());
        positiveNumbers.forEach(System.out::println);
    }
}
