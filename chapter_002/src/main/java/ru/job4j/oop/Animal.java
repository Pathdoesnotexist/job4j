package ru.job4j.oop;

public class Animal {

    public Animal(){
        System.out.println(getClass());
    }

    public static void main(String[] args) {
        Animal cat = new Animal();
    }
}

