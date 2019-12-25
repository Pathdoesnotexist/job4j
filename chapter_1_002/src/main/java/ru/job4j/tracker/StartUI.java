package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;

public class StartUI {

    public void init(Input input, Tracker tracker, List<UserAction> actions) {
        boolean run = true;
        while (run) {
            this.showMenu(actions);
            int select = input.askInt("Select: ", actions.size());
            UserAction action = actions.get(select);
            run = action.execute(input, tracker);
        }
    }

    private void showMenu(List<UserAction> actions) {
        System.out.println("\nMenu.");
        for (int index = 0; index < actions.size(); index++) {
            System.out.println(index + ". " + actions.get(index).getName());
        }
    }

    public static void main(String[] args) {
        Input console = new ConsoleInput();
        Input validate = new ValidateInput(console);
        Tracker tracker = new Tracker();
        List<UserAction> actions = new ArrayList<>();
                actions.add(new CreateItem("Add new Item"));
                actions.add(new ShowAll("Show all items"));
                actions.add(new EditItem("Edit item"));
                actions.add(new DeleteItem("Delete item"));
                actions.add(new FindById("Find item by ID"));
                actions.add(new FindByName("Find item by name"));
                actions.add(new Exit("Exit"));
        new StartUI().init(validate, tracker, actions);
    }
}
