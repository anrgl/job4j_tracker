package ru.job4j.ex;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.is;

public class FindTest {
    @Test(expected = IllegalArgumentException.class)
    public void whenIndexOutOfRange() {
        String rsl = Find.get(new String[] {"one", "two", "three"}, 42);
    }

    @Test
    public void whenIndex0ThenOne() {
        String[] in = {"one", "two", "three"};
        String expected = "one";
        String out = Find.get(in, 0);
        assertThat(out, is(expected));
    }
}