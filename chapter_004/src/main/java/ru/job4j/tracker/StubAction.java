package ru.job4j.tracker;

import java.util.function.Consumer;

public class StubAction extends BaseAction {
    private boolean call = false;

    public StubAction(String name, Consumer<String> output) {
        super(name, output);
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        call = true;
        return false;
    }

    public boolean isCall() {
        return call;
    }
}