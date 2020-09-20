package ru.job4j.oop;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class DummyDicTest {

    @Test
    public void engToRus() {
        DummyDic dummyDic = new DummyDic();
        String in = "Dog";
        String expect = "Неизвестное слово. Dog";
        String out = dummyDic.engToRus(in);
        assertThat(out, is(expect));
    }
}