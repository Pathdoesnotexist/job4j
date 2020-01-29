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
}
