package ru.job4j.tracker;

import java.util.function.Consumer;

public class CreateItem extends BaseAction {
    public CreateItem(String name, Consumer<String> output) {
        super(name, output);
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        getOutput().accept("Enter name: ");
        String name = input.askStr("");
        Item item = new Item(name);
        tracker.add(item);
        return true;
    }


}
