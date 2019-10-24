package ru.job4j.tracker;

public class Main {
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

        for (int i = 0; i < items.length; i++) {
            if (items[i] != null) {
                System.out.println(items[i].getName() + " ID Key: " + items[i].getId());
            } else {
                System.out.println("null");
            }
        }
        System.out.println("\nпроверяем findAll():");
        Item[] withoutNulls = tracker.findAll(items);
        for (int i = 0; i < withoutNulls.length; i++) {
            if (withoutNulls[i] != null) {
                System.out.println(withoutNulls[i].getName() + " ID Key: " + withoutNulls[i].getId());
            } else {
                System.out.println("null");
            }
        }

        System.out.println("\nпроверяем findById() с элементом items[1] и с несуществующим:");
        String idOfOne = items[1].getId();
        String idOfNone = tracker.generateId();

        tracker.findById(idOfOne); //вызывать надо массив без нулей
        tracker.findById(idOfNone);

//        System.out.println("\nпроверяем findByName() по имени Object 4:");
//        tracker.findByName("Object 4");

    }
}
