package ru.job4j.lambda;

import java.util.function.Consumer;

public class ConsumerAndThen {
    public static Consumer<String> consumer(String input) {
        Consumer<String> print = System.out::print;
        Consumer<String> ln = (i) -> System.out.println("");
        return print.andThen(ln);
    }

    public static void main(String[] args) {
        Consumer<Integer> con = (num) -> System.out.println(num + 1);
        Consumer<Integer> con2 = (num) -> System.out.println(num * num);
        con.andThen(con2).accept(2);
    }
}
