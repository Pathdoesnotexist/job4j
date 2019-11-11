package ru.job4j.tracker;

public class TrackerSThree {
    private static final TrackerSThree INSTANCE = new TrackerSThree();

    private TrackerSThree() {
    }

    public static TrackerSThree getInstance() {
        return INSTANCE;
    }

    public Item add(Item model) {
        return model;
    }

    public static void main(String[] args) {
        TrackerSThree tracker = TrackerSThree.getInstance();
    }
}
