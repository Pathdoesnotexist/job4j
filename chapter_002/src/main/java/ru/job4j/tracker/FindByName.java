package ru.job4j.tracker;

public class FindByName implements UserAction {

    private static void printElements(Item[] items) {
        for (Item item : items) {
            if (item != null) {
                System.out.println("Name: \"" + item.getName() + "\" ID Key: " + item.getId());
            } else {
                System.out.println("..and \"null\" to the end of the list length: " + items.length);
                break;
            }
        }
    }

    @Override
    public String name() {
        return "Find items by name";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        String itemName = input.askStr("Enter item name: ");
        Item[] foundByName = tracker.findByName(itemName);
        if (foundByName.length == 0) {
            System.out.println("\nError: name not found");
        } else {
            printElements(foundByName);
        }
        return true;
    }
}
