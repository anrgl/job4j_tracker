package ru.job4j.streamapi;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Deck {
    public static void main(String[] args) {
        List<Card> deck = Stream.of(Suit.values())
                .flatMap(suit -> Stream.of(Value.values())
                    .map(value -> new Card(suit, value)))
                .collect(Collectors.toList());

        deck.forEach(System.out::println);
    }
}
