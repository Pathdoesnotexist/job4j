package ru.job4j.tracker;

import java.util.List;

public class ShowAll extends BaseAction {

    public ShowAll(String name) {
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
        List<Item> itemList = tracker.findAll(tracker.items);
        System.out.println("\n=== Show all items ====");
        if (itemList.size() == 0) {
            System.out.println("Error: list is empty.");
        } else {
            printElements(itemList);
        }
        return true;
    }
}
