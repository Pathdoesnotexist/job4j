package ru.job4j.tracker;

public class Main {
    private static void printElements(Item[] items) {
        for (Item item : items) {
            if (item != null) {
                System.out.println(item.getName() + " ID Key: " + item.getId());
            } else {
                System.out.println("null");
            }
        }
    }

    public static void main(String[] args) {
        Tracker tracker = new Tracker();
        Item[] items = tracker.items;

        Item item1 = new Item("Object 1");
        Item item2 = new Item("Object 2");
        Item item3 = new Item("Object 3");
        Item item4 = new Item("Object 4");
        Item item5 = new Item("Object 4");

        tracker.add(item1);
        tracker.add(item2);
        tracker.add(item3);
        tracker.add(item4);
        tracker.add(item5);
        printElements(items);

        System.out.println("\nпроверяем findAll(), удаляя все null-элементы:");
        Item[] withoutNulls = tracker.findAll(items);
        printElements(withoutNulls);

        System.out.println("\nпроверяем findById() с элементом items[1] \"Object 2\" и с несуществующим:");
        String idOfOne = items[1].getId();
        String idOfNone = tracker.generateId();
        System.out.println(tracker.findById(idOfOne).getName());
        System.out.println(tracker.findById(idOfNone));

        System.out.println("\nпроверяем replace() с элементом items[1] \"Object 2\"");
        Item testReplace = new Item("New Object");
        testReplace.setId(tracker.generateId());
        System.out.println(tracker.replace(idOfOne, testReplace));
        printElements(items);

        System.out.println("\nпроверяем delete() с элементом items[1] \"New Object\"");
        System.out.println(tracker.delete(testReplace.getId()));
        printElements(items);

        System.out.println("\nпроверяем findByName() с элементом \"Object 4\"");
        printElements(tracker.findByName("Object 4"));
    }
}
