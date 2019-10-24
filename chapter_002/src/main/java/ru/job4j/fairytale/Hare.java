package ru.job4j.fairytale;

public class Hare {
    private String name;

    public void setName(String name) {
        this.name = name;
    }
    public void tryEat(Ball ball) {
        System.out.println(name + " попробовал съесть колобка!");
    }
}
