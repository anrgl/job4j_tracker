package ru.job4j.strategy;

public class Cow implements Shape {
    @Override
    public String draw() {
        String ln = System.lineSeparator();
        return "      n..n"
                + ln + "  e___(oo)"
                + ln + "  (____)"
                + ln + "  //  \\\\";
    }
}
