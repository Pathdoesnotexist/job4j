package ru.job4j.hierarchy;

public class Programmer extends Engineer {
    private String language;

    public Coding coding = new Coding();
    public Testing tests = new Testing();
    public Refactoring refactoring = new Refactoring();
}
