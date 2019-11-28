package ru.job4j.tracker;

import java.util.function.Consumer;

public class Exit extends BaseAction {

    public Exit(String name, Consumer<String> output) {
        super(name, output);
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        getOutput().accept("Exiting..");
        return false;
    }
}
