package ru.job4j.tracker;

import java.util.function.Consumer;

public interface UserAction {
    boolean execute(Input input, Tracker tracker);
    String getName();
    Consumer<String> getOutput();
}