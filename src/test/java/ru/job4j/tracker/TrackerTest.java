package ru.job4j.tracker;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
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
        int itemCount = tracker.findAll().size();
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

        List<Item> out = tracker.findByName("Item#1");
        assertThat(out.get(0).getName(), is("Item#1"));
        assertThat(out.get(1).getName(), is("Item#1"));
    }

    @Test
    public void whenId1ThenFindItem() {
        Tracker tracker = new Tracker();
        Item item1 = new Item();
        tracker.add(item1);

        assertThat(tracker.findById(1).getId(), is(1));
    }

    @Test
    public void whenReplaceTrue() {
        Tracker tracker = new Tracker();

        Item oldItem = new Item();
        oldItem.setName("Old Item");
        Item newItem = new Item();
        newItem.setName("New Item");

        tracker.add(oldItem);
        boolean out = tracker.replace(1, newItem);

        assertThat(out, is(true));
        assertThat(tracker.findById(1).getName(), is(newItem.getName()));
    }

    @Test
    public void whenReplaceFalse() {
        Tracker tracker = new Tracker();

        Item oldItem = new Item();
        oldItem.setName("Old Item");
        Item newItem = new Item();
        newItem.setName("New Item");

        tracker.add(oldItem);
        boolean out = tracker.replace(2, newItem);

        assertThat(out, is(false));
    }

    @Test
    public void whenReplace() {
        Tracker tracker = new Tracker();
        Item bug = new Item();
        bug.setName("Bug");
        tracker.add(bug);
        int id = bug.getId();
        Item bugWithDesc = new Item();
        bugWithDesc.setName("Bug with description");
        tracker.replace(id, bugWithDesc);
        assertThat(tracker.findById(id).getName(), is("Bug with description"));
    }

    @Test
    public void findById() {
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

        assertThat(tracker.findById(2).getId(), is(2));
    }

    @Test
    public void delete() {
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

        tracker.delete(2);

        assertThat(tracker.findAll().size(), is(2));
    }

    @Test
    public void whenDelete() {
        Tracker tracker = new Tracker();
        Item bug = new Item();
        bug.setName("Bug");
        tracker.add(bug);
        int id = bug.getId();
        tracker.delete(id);
        assertThat(tracker.findById(id), is(nullValue()));
    }
}