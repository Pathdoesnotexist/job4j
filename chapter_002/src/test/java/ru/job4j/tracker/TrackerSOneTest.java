package ru.job4j.tracker;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class TrackerSOneTest {
    @Test
    public void whenAddNewItemThenTrackerHasSameItem() {
        TrackerSOne first = TrackerSOne.INSTANCE;
        first.add(new Item("test"));
        TrackerSOne second = TrackerSOne.INSTANCE;
        assertThat(first.items[0].getName(), is(second.items[0].getName()));
    }


}
