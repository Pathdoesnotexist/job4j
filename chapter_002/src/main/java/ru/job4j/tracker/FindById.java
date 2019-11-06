package ru.job4j.tracker;

public class FindById implements UserAction {
    @Override
    public String name() {
        return "Find item by Id";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        String id = input.askStr("Enter ID: ");
        Item foundById = tracker.findById(id);
        if (foundById == null) {
            System.out.println("\nError: ID not found");
        } else {
            System.out.print("Name: " + foundById.getName() + "\n");
        }
        return true;
    }
}
