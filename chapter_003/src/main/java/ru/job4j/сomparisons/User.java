package ru.job4j.сomparisons;

public class User implements Comparable<User>{
    private String name;
    private int age;

    User (String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public int compareTo(User o) {
        return this.getAge() - o.getAge();
    }
}
