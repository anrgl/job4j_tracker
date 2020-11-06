package ru.job4j.condition;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

public class PairsCharStringTest {
    @Test
    public void checkTrue() {
        boolean rsl = PairsCharString.check("", "");
        assertThat(rsl, is(true));
    }

    @Test
    public void checkTrue1() {
        boolean rsl = PairsCharString.check("sparkling", "groups");
        assertThat(rsl, is(true));
    }

    @Test
    public void checkFalse() {
        boolean rsl = PairsCharString.check("booking", "grabber");
        assertThat(rsl, is(false));
    }
}