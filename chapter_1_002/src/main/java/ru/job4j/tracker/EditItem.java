package ru.job4j.tracker;

public class EditItem extends BaseAction {
    public EditItem(String name) {
        super(name);
    }


    @Override
    public boolean execute(Input input, Tracker tracker) {
        String id = input.askStr("Enter ID of item to edit: ");
        Item newName = new Item(input.askStr("Enter new name: "));
        if (tracker.rename(id, newName)) {
            System.out.println("Edited successfully");
        } else {
            System.out.println("Error: ID not found");
        }
        return true;
    }
}
