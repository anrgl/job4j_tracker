package ru.job4j.streamapi;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StudentMap {
    public static Map<String, Student> map(List<Student> students) {
        return students.stream().distinct().collect(Collectors.toMap(
                Student::getSurname,
                student -> student,
                (left, right) -> right
        ));
    }
}
