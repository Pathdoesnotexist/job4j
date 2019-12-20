package ru.job4j.exam;

import java.util.*;

public class Group {
    /**
     *
     * @param students список студентов
     * @return карту предметов с именами студентов, посещающих предметы
     */
    public static Map<String, Set<String>> sections(List<Student> students) {
        Map<String, Set<String>> result = new TreeMap<>();
        for (Student student : students) {                                      //заполняем карту ключами-предметами и пустыми сетами значений
            for (String unit : student.getUnits()) {
                result.putIfAbsent(unit, new HashSet<>());
            }
        }
        for (Map.Entry<String, Set<String>> unitEntry : result.entrySet()) {    //получаем каждую пару карты
            for (Student student : students) {                                  //получаем каждого студента
                String unitName = unitEntry.getKey();                           //ключ - имя предмета в карте
                Set<String> unitStudents = unitEntry.getValue();                //значение - пустой сет
                if (student.getUnits().contains(unitName)) {                    // если список предметов студента содержит ключ
                    unitStudents.add(student.getName());                        //добавляем в сет-значение имя студента
                }
            }
        }
        return result;
    }
}