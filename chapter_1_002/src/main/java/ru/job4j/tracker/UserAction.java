package ru.job4j.tracker;

public interface UserAction {
    boolean execute(Input input, Tracker tracker);
    String getName();
}