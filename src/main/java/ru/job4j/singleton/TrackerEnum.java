package ru.job4j.singleton;

import ru.job4j.tracker.Item;

public enum TrackerEnum {
    INSTANCE;
    private final Item[] items = new Item[100];
    private int ids = 1;
    private int size = 0;

    public Item add(Item item) {
        item.setId(ids++);
        items[size++] = item;
        return item;
    }

    public static void main(String[] args) {
        TrackerEnum trackerEnum = TrackerEnum.INSTANCE;
    }
}
