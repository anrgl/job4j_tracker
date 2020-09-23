package ru.job4j.tracker;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class TrackerTest {
    @Test
    public void whenAddNewItemThenTrackerHasSameItem() {
        Tracker tracker = new Tracker();
        Item item = new Item();
        item.setName("test1");
        tracker.add(item);
        Item result = tracker.findById(item.getId());
        assertThat(result.getName(), is(item.getName()));
    }

    @Test
    public void findAll() {
        Tracker tracker = new Tracker();
        Item item1 = new Item();
        Item item2 = new Item();
        Item item3 = new Item();
        tracker.add(item1);
        tracker.add(item2);
        tracker.add(item3);
        int itemCount = tracker.findAll().length;
        assertThat(3, is(itemCount));
    }

    @Test
    public void findByName() {
        Tracker tracker = new Tracker();
        Item item1 = new Item();
        item1.setName("Item#1");
        Item item2 = new Item();
        item2.setName("Item#2");
        Item item3 = new Item();
        item3.setName("Item#1");

        tracker.add(item1);
        tracker.add(item2);
        tracker.add(item3);

        Item[] out = tracker.findByName("Item#1");
        assertThat(out[0].getName(), is("Item#1"));
        assertThat(out[1].getName(), is("Item#1"));
    }
}