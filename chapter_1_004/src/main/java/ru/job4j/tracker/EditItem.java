package ru.job4j.tracker;

import java.util.function.Consumer;

public class EditItem extends BaseAction {

    public EditItem(String name, Consumer<String> output) {
        super(name, output);
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        String id = input.askStr("Enter ID of item to edit: ");
        Item newName = new Item(input.askStr("Enter new name: "));
        if (tracker.rename(id, newName)) {
            getOutput().accept("Edited successfully");
        } else {
            getOutput().accept("Error: ID not found");
        }
        return true;
    }
}
