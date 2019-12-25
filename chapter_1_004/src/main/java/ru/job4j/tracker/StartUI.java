package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class StartUI {
    private final Input input;
    private final Tracker tracker;
    private final Consumer<String> output;

    public StartUI(Input input, Tracker tracker, Consumer<String> output) {
        this.input = input;
        this.tracker = tracker;
        this.output = output;
    }

    public void init(List<UserAction> actions) {
        boolean run = true;
        while (run) {
            this.showMenu(actions);
            int select = input.askInt("Select: ", actions.size());
            UserAction action = actions.get(select);
            run = action.execute(this.input, this.tracker);
        }
    }

    private void showMenu(List<UserAction> actions) {
        output.accept("\nMenu.");
        for (int index = 0; index < actions.size(); index++) {
            output.accept(index + ". " + actions.get(index).getName());
        }
    }

    public static void main(String[] args) {
        Input console = new ConsoleInput();
        Input validate = new ValidateInput(console);
        Tracker tracker = new Tracker();
        Consumer<String> output = System.out::println;

        List<UserAction> actions = new ArrayList<>();
                actions.add(new CreateItem("Add new Item", output));
                actions.add(new ShowAll("Show all items", output));
                actions.add(new EditItem("Edit item", output));
                actions.add(new DeleteItem("Delete item", output));
                actions.add(new FindById("Find item by ID", output));
                actions.add(new FindByName("Find item by name", output));
                actions.add(new Exit("Exit", output));
        new StartUI(validate, tracker, output).init(actions);
    }
}
