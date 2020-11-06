package ru.job4j.condition;

public class AttackRook {
    public static boolean check(String left, String right) {
        return left.toCharArray()[0] == right.toCharArray()[0]
                || left.toCharArray()[1] == right.toCharArray()[1];
    }
}
