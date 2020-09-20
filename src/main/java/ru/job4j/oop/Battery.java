package ru.job4j.oop;

public class Battery {
    private int load;

    public Battery(int load) {
        this.load = load;
    }

    public void exchange(Battery another) {
        another.load += this.load;
        this.load = 0;
    }

    public static void main(String[] args) {
        Battery first = new Battery(100);
        Battery second = new Battery(25);
        first.exchange(second);
        System.out.println("First battery exchange: " + first.load + "%");
        System.out.println("Second battery exchange: " + second.load + "%");
    }
}
