package ru.job4j.tracker;

public class StartUI {

    public void init(Input input, Tracker tracker, UserAction[] actions) {
        boolean run = true;
        while (run) {
            this.showMenu(actions);
            int select = input.askInt("Select: ", actions.length);
            UserAction action = actions[select];
            run = action.execute(input, tracker);
        }
    }

    private void showMenu(UserAction[] actions) {
        System.out.println("\nMenu.");
        for (int index = 0; index < actions.length; index++) {
            System.out.println(index + ". " + actions[index].getName());
        }
    }

    public static void main(String[] args) {
        Input console = new ConsoleInput();
        Input validate = new ValidateInput(console);
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new CreateItem("Add new Item"),
                new ShowAll("Show all items"),
                new EditItem("Edit item"),
                new DeleteItem("Delete item"),
                new FindById("Find item by ID"),
                new FindByName("Find item by name"),
                new Exit("Exit")
        };
        new StartUI().init(validate, tracker, actions);
    }
}
