package ru.job4j.tracker;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class HbmTrackerTest {
    @Test
    public void whenAddItem() {
        HbmTracker tracker = new HbmTracker();
        tracker.add(Item.of("Item #1", "Description #1"));
        var items = tracker.findAll();
        assertEquals("Item #1", items.get(0).getName());
    }

    @Test
    public void whenReplaceItem() {
        HbmTracker tracker = new HbmTracker();
        tracker.add(Item.of("Item #1", "Description #1"));
        tracker.replace(1, Item.of("New Item", "New Description"));
        var items = tracker.findAll();
        assertEquals("New Item", items.get(0).getName());
        assertEquals("New Description", items.get(0).getDescription());
    }

    @Test
    public void whenDeleteItem() {
        HbmTracker tracker = new HbmTracker();
        tracker.add(Item.of("Item #1", "Description #1"));
        tracker.delete(1);
        var items = tracker.findAll();
        assertEquals(0, items.size());
    }

    @Test
    public void whenFindAllItems() {
        HbmTracker tracker = new HbmTracker();
        tracker.add(Item.of("Item #1", "Description #1"));
        tracker.add(Item.of("Item #2", "Description #2"));
        var items = tracker.findAll();
        assertEquals(2, items.size());
    }

    @Test
    public void whenFindById() {
        HbmTracker tracker = new HbmTracker();
        Item expect = Item.of("Item #1", "Description #1");
        tracker.add(expect);
        Item item = tracker.findById(1);
        assertEquals(expect, item);
    }

    @Test
    public void whenFindByName() {
        HbmTracker tracker = new HbmTracker();
        Item expect = Item.of("Item #1", "Description #1");
        tracker.add(expect);
        List<Item> items = tracker.findByName("Item #1");
        assertEquals(expect, items.get(0));
    }
}