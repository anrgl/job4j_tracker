package ru.job4j.tracker;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

public class ItemTest {
    @Test
    public void whenItemSorted() {
        List<Item> items = Arrays.asList(
                new Item(42, "Bye the bread"),
                new Item(5, "Fix bug"),
                new Item(1, "First go sleep")
        );
        Collections.sort(items, new SortByNameItem());
        List<Item> expect = Arrays.asList(
                new Item(42, "Bye the bread"),
                new Item(1, "First go sleep"),
                new Item(5, "Fix bug")
        );
        assertThat(items, is(expect));
    }

    @Test
    public void whenItemReverseSorted() {
        List<Item> items = Arrays.asList(
                new Item(1, "First go sleep"),
                new Item(5, "Fix bug"),
                new Item(42, "Bye the bread")
        );
        Collections.sort(items, new ReverseByNameItem());
        List<Item> expect = Arrays.asList(
                new Item(5, "Fix bug"),
                new Item(1, "First go sleep"),
                new Item(42, "Bye the bread")
        );
        assertThat(items, is(expect));
    }
}