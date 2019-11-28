package ru.job4j.tracker;

import java.util.List;
import java.util.function.Consumer;

public class ShowAll extends BaseAction {
    public ShowAll(String name, Consumer<String> output) {
        super(name, output);
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        List<Item> itemList = tracker.findAll(tracker.items);
        getOutput().accept("\n=== Show all items ====");
        if (itemList.size() == 0) {
            getOutput().accept("Error: list is empty.");
        } else {
            for (Item item : itemList) {
                if (item != null) {
                    getOutput().accept("Name: \"" + item.getName() + "\" ID Key: " + item.getId());
                }
            }
        }
        return true;
    }
}
