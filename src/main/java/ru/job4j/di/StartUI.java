package ru.job4j.di;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class StartUI {
    @Autowired
    private Store store;
    @Autowired
    private ConsoleInput input;

//    public StartUI(Store store, ConsoleInput input) {
//        this.store = store;
//        this.input = input;
//    }

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
