package ru.job4j.tracker;

public class TrackerSTwo extends Tracker {
    private static TrackerSTwo instance;

    private TrackerSTwo() {
    }

    public static TrackerSTwo getInstance() {
        if (instance == null) {
            instance = new TrackerSTwo();
        }
        return instance;
    }
}