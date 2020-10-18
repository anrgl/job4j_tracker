package ru.job4j.streamapi;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class StudentMapTest {
    private List<Student> students = new ArrayList<>();

    @Before
    public void setUp() {
        students.add(new Student(10, "Surname1"));
        students.add(new Student(20, "Surname2"));
        students.add(new Student(30, "Surname3"));
        students.add(new Student(30, "Surname3"));
    }

    @Test
    public void whenListThenMap() {
        Map<String, Student> expect = new HashMap<>();
        expect.put("Surname1", students.get(0));
        expect.put("Surname2", students.get(1));
        expect.put("Surname3", students.get(2));

        Map<String, Student> out = StudentMap.map(students);
        assertThat(out, is(expect));
    }
}