package ru.job4j.map;

import java.util.*;

/**
 * Пользователь
 * @author Andrey Varshavsky
 * @version 1.0
 * @since 27.01.2020
 */

public class User {
    private String name;
    private int children;
    private Calendar birthday;

    public User(String name, int children, Calendar birthday) {
        this.name = name;
        this.children = children;
        this.birthday = birthday;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, children, birthday);
    }

    public static void main(String[] args) {
        User user1 = new User("Dmitriy", 2, new GregorianCalendar(1990, Calendar.MARCH, 25));
        User user2 = new User("Dmitriy", 2, new GregorianCalendar(1990, Calendar.MARCH, 25));
        Object object = new Object();
        Map<User, Object> map = new HashMap<>();
        map.put(user1, object);
        map.put(user2, object);
        System.out.println(map);
    }
}
