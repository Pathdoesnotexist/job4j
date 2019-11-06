package ru.job4j.tracker;

public class EditItem implements UserAction {
    @Override
    public String name() {
        return "Edit item";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        String id = input.askStr("Enter ID of item to edit: ");
        Item newName = new Item(input.askStr("Enter new name: "));
        if (tracker.replace(id, newName)) {
            System.out.println("\nEdited successfully");
        } else {
            System.out.println("\nError: ID not found");
        }
        return true;
    }
}
