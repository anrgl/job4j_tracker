package ru.job4j.condition;

public class Game {
    public static int checkGame(double percent, int prize, int pay) {
        return (percent * prize >= pay) ? (int) (percent * prize - pay) : 0;
    }
}
