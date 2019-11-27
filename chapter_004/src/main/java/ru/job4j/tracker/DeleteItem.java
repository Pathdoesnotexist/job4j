package ru.job4j.tracker;

public class DeleteItem extends BaseAction {

    public DeleteItem(String name) {
        super(name);
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        String id = input.askStr("Enter ID: ");
        if (tracker.delete(id)) {
            System.out.println("Item deleted!");
        } else {
            System.out.println("Error: ID not found");
        }
        return true;
    }
}
