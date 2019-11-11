package ru.job4j.tracker;

public class TrackerSTwo {
    private static TrackerSTwo instance;

    private TrackerSTwo() {
    }

    public static TrackerSTwo getInstance() {
        if (instance == null) {
            instance = new TrackerSTwo();
        }
        return instance;
    }

    public Item add(Item model) {
        return model;
    }
}