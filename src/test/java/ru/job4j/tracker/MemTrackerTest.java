package ru.job4j.tracker;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertThat;

public class MemTrackerTest {
    @Test
    public void whenAddNewItemThenTrackerHasSameItem() {
        MemTracker memTracker = new MemTracker();
        Item item = new Item();
        item.setName("test1");
        memTracker.add(item);
        Item result = memTracker.findById(item.getId());
        assertThat(result.getName(), is(item.getName()));
    }

    @Test
    public void findAll() {
        MemTracker memTracker = new MemTracker();
        Item item1 = new Item();
        Item item2 = new Item();
        Item item3 = new Item();
        memTracker.add(item1);
        memTracker.add(item2);
        memTracker.add(item3);
        int itemCount = memTracker.findAll().size();
        assertThat(3, is(itemCount));
    }

    @Test
    public void findByName() {
        MemTracker memTracker = new MemTracker();
        Item item1 = new Item();
        item1.setName("Item#1");
        Item item2 = new Item();
        item2.setName("Item#2");
        Item item3 = new Item();
        item3.setName("Item#1");

        memTracker.add(item1);
        memTracker.add(item2);
        memTracker.add(item3);

        List<Item> out = memTracker.findByName("Item#1");
        assertThat(out.get(0).getName(), is("Item#1"));
        assertThat(out.get(1).getName(), is("Item#1"));
    }

    @Test
    public void whenId1ThenFindItem() {
        MemTracker memTracker = new MemTracker();
        Item item1 = new Item();
        memTracker.add(item1);

        assertThat(memTracker.findById(1).getId(), is(1));
    }

    @Test
    public void whenReplaceTrue() {
        MemTracker memTracker = new MemTracker();

        Item oldItem = new Item();
        oldItem.setName("Old Item");
        Item newItem = new Item();
        newItem.setName("New Item");

        memTracker.add(oldItem);
        boolean out = memTracker.replace(1, newItem);

        assertThat(out, is(true));
        assertThat(memTracker.findById(1).getName(), is(newItem.getName()));
    }

    @Test
    public void whenReplaceFalse() {
        MemTracker memTracker = new MemTracker();

        Item oldItem = new Item();
        oldItem.setName("Old Item");
        Item newItem = new Item();
        newItem.setName("New Item");

        memTracker.add(oldItem);
        boolean out = memTracker.replace(2, newItem);

        assertThat(out, is(false));
    }

    @Test
    public void whenReplace() {
        MemTracker memTracker = new MemTracker();
        Item bug = new Item();
        bug.setName("Bug");
        memTracker.add(bug);
        int id = bug.getId();
        Item bugWithDesc = new Item();
        bugWithDesc.setName("Bug with description");
        memTracker.replace(id, bugWithDesc);
        assertThat(memTracker.findById(id).getName(), is("Bug with description"));
    }

    @Test
    public void findById() {
        MemTracker memTracker = new MemTracker();
        Item item1 = new Item();
        item1.setName("Item#1");
        Item item2 = new Item();
        item2.setName("Item#2");
        Item item3 = new Item();
        item3.setName("Item#1");

        memTracker.add(item1);
        memTracker.add(item2);
        memTracker.add(item3);

        assertThat(memTracker.findById(2).getId(), is(2));
    }

    @Test
    public void delete() {
        MemTracker memTracker = new MemTracker();
        Item item1 = new Item();
        item1.setName("Item#1");
        Item item2 = new Item();
        item2.setName("Item#2");
        Item item3 = new Item();
        item3.setName("Item#1");

        memTracker.add(item1);
        memTracker.add(item2);
        memTracker.add(item3);

        memTracker.delete(2);

        assertThat(memTracker.findAll().size(), is(2));
    }

    @Test
    public void whenDelete() {
        MemTracker memTracker = new MemTracker();
        Item bug = new Item();
        bug.setName("Bug");
        memTracker.add(bug);
        int id = bug.getId();
        memTracker.delete(id);
        assertThat(memTracker.findById(id), is(nullValue()));
    }
}