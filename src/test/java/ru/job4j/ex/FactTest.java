package ru.job4j.ex;

import org.junit.Test;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;

public class FactTest {
    @Test(expected = IllegalArgumentException.class)
    public void whenNumberIsNegative() {
        new Fact().calc(-5);
    }

    @Test
    public void whenNumberIsPositive() {
        int result = new Fact().calc(5);
        int expected = 120;
        assertThat(result, is(expected));
    }
}