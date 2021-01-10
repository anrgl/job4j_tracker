package ru.job4j.tracker;

import java.util.List;

public class ShowAction implements UserAction {
    private final Output out;

    public ShowAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Show all items";
    }

    @Override
    public boolean execute(Input input, MemTracker memTracker) {
        List<Item> items = memTracker.findAll();
        for (Item item : items) {
            out.println(item.getName());
        }
        return true;
    }
}
