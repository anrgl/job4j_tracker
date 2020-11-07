package ru.job4j.lambda;

import java.util.Arrays;
import java.util.Optional;

public class OptionalIfPresent {
    public static void ifPresent(int[] data) {
        Optional.of(max(data)).ifPresent((n) -> {
            if (n.isPresent()) {
                System.out.println("Max: " + n.get());
            } else {
                System.out.print("");
            }
        });
    }

    private static Optional<Integer> max(int[] data) {
        if (data.length == 0) {
            return Optional.empty();
        }
        int max = Arrays.stream(data).max().getAsInt();
        return Optional.of(max);
    }
}
