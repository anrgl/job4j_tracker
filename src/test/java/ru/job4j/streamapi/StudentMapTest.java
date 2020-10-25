package ru.job4j.streamapi;

import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.Map;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class StudentMapTest {
    private List<Student> students;

    @Before
    public void setUp() {
        students = List.of(
                new Student(10, "Surname1"),
                new Student(20, "Surname2"),
                new Student(30, "Surname3"),
                new Student(30, "Surname3")
        );
    }

    @Test
    public void whenListThenMap() {
        Map<String, Student> expect = Map.of(
                "Surname1", students.get(0),
                "Surname2", students.get(1),
                "Surname3", students.get(2)
        );

        Map<String, Student> out = StudentMap.map(students);
        assertThat(out, is(expect));
    }
}