package ru.job4j.di;

public class StartUI {
    private final Store store;
    private final ConsoleInput input;

    public StartUI(Store store, ConsoleInput input) {
        this.store = store;
        this.input = input;
    }

    public void addFromConsoleInput() {
        String value = input.askStr("Enter you text: ");
        store.add(value);
    }

    public void add(String value) {
        store.add(value);
    }

    public void print() {
        for (var value : store.getAll()) {
            System.out.println(value);
        }
    }
}
