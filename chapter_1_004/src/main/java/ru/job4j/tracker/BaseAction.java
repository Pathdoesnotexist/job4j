package ru.job4j.tracker;

import java.util.function.Consumer;

public abstract class BaseAction implements UserAction {
    private final String name;
    private final Consumer<String> output;

   public BaseAction(final String name, Consumer<String> output) {
        this.name = name;
       this.output = output;
   }

    public String getName() {
        return name;
    }

    public Consumer<String> getOutput() {
        return output;
    }
}
