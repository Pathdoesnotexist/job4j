package ru.job4j.tracker;

public class ShowAll extends BaseAction {

    public ShowAll(String name) {
        super(name);
    }

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
    public boolean execute(Input input, Tracker tracker) {
        Item[] itemList = tracker.findAll(tracker.items);
        System.out.println("\n=== Show all items ====");
        if (itemList.length == 0) {
            System.out.println("Error: list is empty.");
        } else {
            printElements(itemList);
        }
        return true;
    }
}
