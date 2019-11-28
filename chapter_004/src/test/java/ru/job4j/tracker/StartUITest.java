package ru.job4j.tracker;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class StartUITest {
    @Test
    public void whenAddItem() {
        String[] answers = {"Fix PC"};
        Input input = new StubInput(answers);
        Tracker tracker = new Tracker();
        Consumer<String> output = System.out::println;
        UserAction createItem = new CreateItem("Add new Item", output);
        createItem.execute(input, tracker);
        Item created = tracker.findAll(tracker.items).get(0);
        Item expected = new Item("Fix PC");
        assertThat(created.getName(), is(expected.getName()));
    }

    @Test
    public void whenReplaceItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("new item");
        Consumer<String> output = System.out::println;
        tracker.add(item);
        String[] answers = {
                item.getId(), // id сохраненной заявки в объект tracker.
                "replaced item"
        };
        UserAction editItem = new EditItem("Edit item", output);
        editItem.execute(new StubInput(answers), tracker);
        Item replaced = tracker.findById(item.getId());
        assertThat(replaced.getName(), is("replaced item"));
    }

    @Test
    public void whenDeleteItem() {
        Tracker tracker = new Tracker();
        Item item1 = new Item("1");
        Item item2 = new Item("2");
        Item item3 = new Item("3");
        tracker.add(item1);
        tracker.add(item2);
        tracker.add(item3);
        tracker.delete(item2.getId());
        assertThat(tracker.items.get(1).getName(), is("3"));
    }

    @Test
    public void whenExit() {
        Consumer<String> output = System.out::println;
        StubInput input = new StubInput(
                new String[] {"0"}
        );
        StubAction action = new StubAction("Stub action", output);
        List<UserAction> list = new ArrayList<>();
        list.add(action);
        new StartUI(input, new Tracker(), output).init(list);
        assertThat(action.isCall(), is(true));
    }

}