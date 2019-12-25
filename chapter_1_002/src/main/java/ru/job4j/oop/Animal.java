package ru.job4j.oop;

public class Animal {

    public Animal(String name) {
        System.out.println(getClass());
    }

    public static void main(String[] args) {
        Animal cat = new Animal("Garfield");
    }
}

