package ru.job4j.tracker;

public class TrackerSFour extends Tracker {
    private TrackerSFour() {
    }

    public static TrackerSFour getInstance() {
        return Holder.INSTANCE;
    }

    public Item add(Item model) {
        return model;
    }

    private static final class Holder {
        private static final TrackerSFour INSTANCE = new TrackerSFour();
    }

    public static void main(String[] args) {
        TrackerSFour tracker = TrackerSFour.getInstance();
    }
}