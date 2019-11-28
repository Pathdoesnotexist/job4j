package ru.job4j.tracker;

import java.util.function.Consumer;

public class FindById extends BaseAction {

    public FindById(String name, Consumer<String> output) {
        super(name, output);
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        String id = input.askStr("Enter ID: ");
        Item foundById = tracker.findById(id);
        if (foundById == null) {
            getOutput().accept("Error: ID not found");
        } else {
            getOutput().accept("Name: " + foundById.getName() + "\n");
        }
        return true;
    }
}
