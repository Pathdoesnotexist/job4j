package ru.job4j.exam;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Group {
    /**
     * Получения карты k: предмет v: список посещающих студентов
     * @param students список студентов
     * @return карту предметов с именами студентов, посещающих предметы
     */
    public static Map<String, Set<String>> sections(List<Student> students) {
        return students.stream()
                .flatMap(student -> student.getUnits().stream())
                .distinct()
                .collect(Collectors.toMap(unit -> unit, unit -> collectStudentsForUnit(unit, students)));
    }
    /**
     *
     * @param unitName имя предмета
     * @param students список студентов
     * @return набор имен студентов для данного предмета
     */
    private static TreeSet<String> collectStudentsForUnit(String unitName, List<Student> students) {
        return students.stream()
                .filter(student -> student.getUnits().contains(unitName))
                .map(Student::getName)
                .collect(Collectors.toCollection(TreeSet::new));
    }
}