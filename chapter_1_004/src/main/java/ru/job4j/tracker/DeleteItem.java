package ru.job4j.tracker;

import java.util.function.Consumer;

public class DeleteItem extends BaseAction {

    public DeleteItem(String name, Consumer<String> output) {
        super(name, output);
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        String id = input.askStr("Enter ID: ");
        if (tracker.delete(id)) {
            getOutput().accept("Item deleted!");
        } else {
            getOutput().accept("Error: ID not found");
        }
        return true;
    }
}
