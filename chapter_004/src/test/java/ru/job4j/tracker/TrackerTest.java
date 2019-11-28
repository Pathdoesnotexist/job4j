package ru.job4j.tracker;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;
import java.util.function.Consumer;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class TrackerTest {

    @Test
    public void findAllFindById() {
        Tracker tracker = new Tracker();
        List<Item> items = tracker.items;
        int findAllCount = 5;
        String findByIdWin = "Object 2";

        Item item1 = new Item("Object 1");
        Item item2 = new Item("Object 2");
        Item item3 = new Item("Object 3");
        Item item4 = new Item("Object 4");
        Item item5 = new Item("Object 4");

        tracker.add(item1);
        tracker.add(item2);
        tracker.add(item3);
        tracker.add(item4);
        tracker.add(item5);

        List<Item> withoutNulls = tracker.findAll(items);
        Assert.assertEquals(withoutNulls.size(), findAllCount);

        String idOfOne = items.get(1).getId();
        String idOfNone = "false ID injection";
        Assert.assertEquals(tracker.findById(idOfOne).getName(), findByIdWin);
        Assert.assertNull(tracker.findById(idOfNone));
    }

    @Test
    public void whenAddNewItemThenTrackerHasSameItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("test1");
        tracker.add(item);
        Item result = tracker.findById(item.getId());
        assertThat(result.getName(), is(item.getName()));
    }

    @Test
    public void whenReplaceNameThenReturnNewName() {
        Tracker tracker = new Tracker();
        Item previous = new Item("test1");
        // Добавляем заявку в трекер. Теперь в объект проинициализирован id.
        tracker.add(previous);
        // Создаем новую заявку.
        Item next = new Item("test2");
        // Проставляем старый id из previous, который был сгенерирован выше.
        next.setId(previous.getId());
        // Обновляем заявку в трекере.
        tracker.rename(previous.getId(), next);
        // Проверяем, что заявка с таким id имеет новые имя test2.
        assertThat(tracker.findById(previous.getId()).getName(), is("test2"));
    }

    @Test
    public void whenPrtMenu() {
        Consumer<String> output = System.out::println;
        StubInput input = new StubInput(
                new String[] {"0"}
        );
        StubAction action = new StubAction("Stub action", output);
        List<UserAction> list = new ArrayList<>();
        list.add(action);

        new StartUI(input, new Tracker(), output).init(list);
        String expect = new StringJoiner(System.lineSeparator(), "", System.lineSeparator())
                .add("\nMenu.")
                .add("0. Stub action")
                .toString();
        assertThat(output.toString(), is(expect));
    }

    @Test
    public void whenShowAll() {
        Consumer<String> output = System.out::println;
        Tracker tracker = new Tracker();
        Item item = new Item("fix bug");
        tracker.add(item);
        ShowAll act = new ShowAll("Show all items", output);
        act.execute(new StubInput(new String[]{}), tracker);
        String expect = new StringJoiner(System.lineSeparator(), "", System.lineSeparator())
                .add("\n=== Show all items ====")
                .add("Name: \"" + item.getName() + "\" ID Key: " + item.getId())
                .toString();
        assertThat(output.toString(), is(expect));
    }

    @Test
    public void whenFindByName() {
        Consumer<String> output = System.out::println;
        Tracker tracker = new Tracker();
        Item itemOne = new Item("one");
        tracker.add(itemOne);
        FindByName act = new FindByName("Find item by name", output);
        act.execute(new StubInput(new String[] {"one"}), tracker);
        String expect = new StringJoiner(System.lineSeparator(), "", System.lineSeparator())
                .add("Name: \"" + itemOne.getName() + "\" ID Key: " + itemOne.getId())
                .toString();
        assertThat(output.toString(), is(expect));
    }
}