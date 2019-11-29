package ru.job4j.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class School {
    public List<Student> group = new ArrayList();

    public List<Student> collect(List<Student> students, Predicate<Student> userFilter) {
        return students.stream().filter(userFilter).collect(Collectors.toList());
    }
}
