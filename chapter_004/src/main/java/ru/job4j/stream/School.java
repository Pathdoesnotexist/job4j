package ru.job4j.stream;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class School {
    /**
     * Список, для хранения учащихся в классе
     */
    public ArrayList<Student> group = new ArrayList<>();

    public List<Student> levelOf(List<Student> students, int bound) {
        return students.stream().filter(x -> x != null && x.getSurname() != null).sorted().distinct().takeWhile(x -> x.getScore() > bound).collect(Collectors.toList());
    }
    /**
     * Фильтрация учеников по среднему баллу
     * @param students список учашихся в классе
     * @param userFilter условие фильтрации по среднему баллу
     * @return отфильтрованный список учащихся
     */
    public List<Student> collect(List<Student> students, Predicate<Student> userFilter) {
        return students.stream().filter(userFilter).collect(Collectors.toList());
    }
    /**
     * Преобразование списка студентов в карту k:фамилия v:студент
     * @param students список студентов
     * @return карту студентов, k:фамилия v:студент
     */
    public Map<String, Student> listToMap(List<Student> students) {
        return students.stream().collect(Collectors.toMap(x -> x.getSurname(), x -> x, (e1, e2) -> e1));
//        return students.stream().distinct().collect(Collectors.toMap(Student::getSurname, x -> x));
    }
}
