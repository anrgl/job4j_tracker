package ru.job4j.tracker;

import org.junit.Test;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;

public class StartUITest {
    @Test
    public void whenAddItem() {
        String[] answers = {"Fix PC"};
        Input input = new StubInput(answers);
        Tracker tracker = new Tracker();
        StartUI.createItem(input, tracker);
        Item created = tracker.findAll()[0];
        Item expected = new Item("Fix PC");
        assertThat(created.getName(), is(expected.getName()));
    }

    @Test
    public void whenReplaceItem() {
        String[] answers = {"Item #1"};
        Input input = new StubInput(answers);
        Tracker tracker = new Tracker();
        StartUI.createItem(input, tracker);
        boolean result = tracker.replace(1, new Item("Item #42"));
        Item replaced = tracker.findAll()[0];
        Item expected = new Item("Item #42");
        assertThat(result, is(true));
        assertThat(replaced.getName(), is(expected.getName()));

    }

    @Test
    public void whenDeleteItem() {
        String[] answers = {"Item #1"};
        Input input = new StubInput(answers);
        Tracker tracker = new Tracker();
        StartUI.createItem(input, tracker);
        boolean expected = tracker.delete(1);
        assertThat(expected, is(true));
    }
}