package ru.job4j.tracker;

public class TrackerSThree extends Tracker {
    private static final TrackerSThree INSTANCE = new TrackerSThree();

    private TrackerSThree() {
    }

    public static TrackerSThree getInstance() {
        return INSTANCE;
    }
}
