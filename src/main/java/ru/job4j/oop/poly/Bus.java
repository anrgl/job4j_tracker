package ru.job4j.oop.poly;

public class Bus implements Transport {
    @Override
    public void run() {
        System.out.println("Эрон дон дон...");
    }

    @Override
    public void passengers(int count) {
        System.out.printf("%d passengers in bus.", count);
    }

    @Override
    public double fillUp(int count) {
        return 42.50 * count;
    }
}
