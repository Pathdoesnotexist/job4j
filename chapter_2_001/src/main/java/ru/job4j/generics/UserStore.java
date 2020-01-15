package ru.job4j.generics;

/**
 * Хранилище объектов класса User
 */
public class UserStore extends AbstractStore<User> {

    public UserStore(int size) {
        super(size);
    }
}
