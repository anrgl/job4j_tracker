package ru.job4j.ex;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.is;

public class FindElTest {
    @Test(expected = ElementNotFoundException.class)
    public void whenKeyNotFound() throws ElementNotFoundException {
        FindEl.indexOf(new String[] {"Key", "not", "found"}, "Java");
    }

    @Test
    public void whenKeyFound() throws ElementNotFoundException {
        int out = FindEl.indexOf(new String[] {"C", "C++", "Java", "C#"}, "Java");
        int expect = 2;
        assertThat(out, is(expect));
    }
}