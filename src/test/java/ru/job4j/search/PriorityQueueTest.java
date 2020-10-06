package ru.job4j.search;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.is;

public class PriorityQueueTest {
    @Test
    public void whenHigherPriority() {
        PriorityQueue queue = new PriorityQueue();
        queue.put(new Task("low", 5));
        queue.put(new Task("urgent", 1));
        queue.put(new Task("middle", 3));
        Task result = queue.take();
        assertThat(result.getDesc(), is("urgent"));
    }

    @Test
    public void whenAllEqualsPriority() {
        PriorityQueue queue = new PriorityQueue();
        queue.put(new Task("Alpha", 42));
        queue.put(new Task("Beta", 42));
        queue.put(new Task("Gamma", 42));
        Task result = queue.take();
        assertThat(result.getDesc(), is("Gamma"));
    }
}