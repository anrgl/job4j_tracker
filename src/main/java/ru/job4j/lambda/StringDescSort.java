package ru.job4j.lambda;

import java.util.Arrays;
import java.util.Comparator;

public class StringDescSort {
    public static void main(String[] args) {
        Comparator<String> cmpStrDesc = (left, right) -> {
            System.out.println("compare : " + left + " length - " + left.length() + ", "
                    + right + " length - " + right.length());
            return right.length() - left.length();
        };
        String[] names = {"Petr", "Vasya", "Ivan", "Max", "Andrey"};
        Arrays.sort(names, cmpStrDesc);
        System.out.println(Arrays.toString(names));
    }
}
