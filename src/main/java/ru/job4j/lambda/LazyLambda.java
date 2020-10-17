package ru.job4j.lambda;

import java.util.Arrays;
import java.util.Comparator;

public class LazyLambda {
    public static void main(String[] args) {
        String[] names = {
                "Ivan",
                "Petr"
        };
        Comparator<String> lazyCmp = (left, right) -> {
            System.out.println(left + " : " + right);
            return left.length() - right.length();
        };
        Arrays.sort(names, lazyCmp);
    }
}
