package ru.job4j.oop.poly;

public interface Transport {
    void run();

    void passengers(int count);

    double fillUp(int count);
}
