package ru.job4j.tracker;

//import java.util.Scanner;
public class StartUI {

    public void init(Input input, Tracker tracker) {
        boolean run = true;
        while (run) {
            this.showMenu();
            int select;
            do {
                select = input.askInt("Select: ");
            }
            while (select < 0 || select > 6);
            if (select == 0) {
                System.out.println("\n=== Create a new Item ====");
                String name = input.askStr("Enter name: ");
                Item item = new Item(name);
                tracker.add(item);
                System.out.print("Item " + name + "created successfully!\n");
            } else if (select == 1) {
                System.out.println("\n=== Show all items ====");
                if (tracker.findAll(tracker.items).length == 0) {
                    System.out.println("Error: list is empty.");
                } else {
                    tracker.printElements(tracker.findAll(tracker.items));
                }
            } else if (select == 2) {
                System.out.println("\n=== Edit item ====");
                String id = input.askStr("Enter ID of item to edit: ");
                Item newName = new Item(input.askStr("Enter new name: "));
                if (tracker.replace(id, newName)) {
                    System.out.println("\nEdited successfully");
                } else {
                    System.out.println("\nError: ID not found");
                }
            } else if (select == 3) {
                System.out.println("\n=== Delete item ====");
                String id = input.askStr("Enter ID: ");
                if (tracker.delete(id)) {
                    System.out.println("\nItem deleted!");
                } else {
                    System.out.println("\nError: ID not found");
                }
            } else if (select == 4) {
                System.out.println("\n=== Find item by Id ====");
                String id = input.askStr("Enter ID: ");
                if (tracker.findById(id) == null) {
                    System.out.println("\nError: ID not found");
                } else {
                    System.out.print("Name: " + tracker.findById(id).getName() + "\n");
                }
            } else if (select == 5) {
                System.out.println("\n=== Find items by name ====");
                String itemName = input.askStr("Enter item name: ");
                if (tracker.findByName(itemName).length == 0) {
                    System.out.println("\nError: name not found");
                } else {
                    tracker.printElements(tracker.findByName(itemName));
                }
            } else {
                System.out.println("\nTracker closed");
                run = false;
            }
        }
    }

    private void showMenu() {
        System.out.println("\n|||||||||||||||||||||||||||");
        System.out.println("|||         MENU        |||");
        System.out.println("|||||||||||||||||||||||||||");
        System.out.println("0. Add new Item");
        System.out.println("1. Show all items");
        System.out.println("2. Edit item");
        System.out.println("3. Delete item");
        System.out.println("4. Find item by Id");
        System.out.println("5. Find items by name");
        System.out.println("6. Exit Program");
    }

    public static void main(String[] args) {
        Input input = new ConsoleInput();
        Tracker tracker = new Tracker();
        new StartUI().init(input, tracker);
    }
}