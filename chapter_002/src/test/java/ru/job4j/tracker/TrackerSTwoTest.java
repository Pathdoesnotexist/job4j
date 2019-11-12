package ru.job4j.tracker;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class TrackerSTwoTest {
    @Test
    public void whenAddNewItemThenTrackerHasSameItem() {
        TrackerSTwo first = TrackerSTwo.getInstance();
        Item[] items = first.items;
        first.add(new Item("testOne"));
        TrackerSTwo second = TrackerSTwo.getInstance();

        Item[] firstShow = first.findAll(items);
        Item[] secondShow = second.findAll(items);

        assertThat(secondShow, is(firstShow));
    }
}