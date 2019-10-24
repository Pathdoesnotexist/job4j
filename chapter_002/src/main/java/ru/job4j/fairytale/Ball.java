package ru.job4j.fairytale;

public class Ball {
    private String name;

    public void setName(String name) {
        this.name = name;
    }
    public void runAway() {
        System.out.println(this.name + " убежал!");
    }
}
