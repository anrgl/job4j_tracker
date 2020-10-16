package ru.job4j.lambda;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class SearchAttTest {
    @Test
    public void filterSize() {
        List<Attachment> in = Arrays.asList(
                new Attachment("First", 10),
                new Attachment("Second", 42),
                new Attachment("Third", 100),
                new Attachment("Fourth", 101)
        );
        List<Attachment> expect = Arrays.asList(
                new Attachment("Fourth", 101)
        );
        List<Attachment> out = SearchAtt.filterSize(in);
        assertEquals(out, expect);
    }

    @Test
    public void filterName() {
        List<Attachment> in = Arrays.asList(
                new Attachment("First", 10),
                new Attachment("Second bug", 42),
                new Attachment("Third", 100),
                new Attachment("Fourth", 101)
        );
        List<Attachment> expect = Arrays.asList(
                new Attachment("Second bug", 42)
        );
        List<Attachment> out = SearchAtt.filterName(in);
        assertEquals(out, expect);
    }
}