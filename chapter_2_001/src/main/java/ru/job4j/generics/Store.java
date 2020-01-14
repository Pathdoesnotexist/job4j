package ru.job4j.generics;

/**
 * @author Andrey Varshavsky
 * @version 1.0
 * @since 11.01.2020
 */
public interface Store<T extends Base> {

    void add(T model);

    boolean replace(String id, T model);

    boolean delete(String id);

    T findById(String id);
}
