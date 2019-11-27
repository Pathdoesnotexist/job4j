package ru.job4j.tracker;

public class Exit extends BaseAction {

    public Exit(String name) {
        super(name);
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        System.out.print("Exiting..");
        return false;
    }
}
