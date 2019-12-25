package ru.job4j.tracker;

public class FindById extends BaseAction {

    public FindById(String name) {
        super(name);
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        String id = input.askStr("Enter ID: ");
        Item foundById = tracker.findById(id);
        if (foundById == null) {
            System.out.println("Error: ID not found");
        } else {
            System.out.print("Name: " + foundById.getName() + "\n");
        }
        return true;
    }
}
