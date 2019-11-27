package ru.job4j.tracker;

public abstract class BaseAction implements UserAction {
    private final String name;

   public BaseAction(final String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
