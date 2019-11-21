package ru.job4j.bank;

public class User implements Comparable<User> {
    private String name;
    private int passport;

    User(String name, int passport) {
        this.name = name;
        this.passport = passport;
    }

    public String getName() {
        return name;
    }
    public int getPassport() {
        return passport;
    }

    @Override
    public int compareTo(User o) {
        return this.getName().compareTo(o.getName());
    }
}
