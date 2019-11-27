package ru.job4j.tracker;

import java.util.List;

public class FindByName extends BaseAction {

    public FindByName(String name) {
        super(name);
    }

    private static void printElements(List<Item> items) {
        for (Item item : items) {
            if (item != null) {
                System.out.println("Name: \"" + item.getName() + "\" ID Key: " + item.getId());
            }
        }
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        String itemName = input.askStr("Enter item name: ");
        List<Item> foundByName = tracker.findByName(itemName);
        if (foundByName.size() == 0) {
            System.out.println("Error: name not found");
        } else {
            printElements(foundByName);
        }
        return true;
    }
}
