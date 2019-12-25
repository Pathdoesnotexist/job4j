package ru.job4j.tracker;

import java.util.List;
import java.util.function.Consumer;

public class FindByName extends BaseAction {

    public FindByName(String name, Consumer<String> output) {
        super(name, output);
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        String itemName = input.askStr("Enter item name: ");
        List<Item> foundByName = tracker.findByName(itemName);
        if (foundByName.size() == 0) {
            getOutput().accept("Error: name not found");
        } else {
            for (Item item : foundByName) {
                if (item != null) {
                    getOutput().accept("Name: \"" + item.getName() + "\" ID Key: " + item.getId());
                }
            }
        }
        return true;
    }
}
