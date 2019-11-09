package ru.job4j.tracker;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.StringJoiner;

public class TrackerTest {

    @Test
    public void findAllFindById() {
        Tracker tracker = new Tracker();
        Item[] items = tracker.items;
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

        Item[] withoutNulls = tracker.findAll(items);
        Assert.assertEquals(withoutNulls.length, findAllCount);

        String idOfOne = items[1].getId();
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
        tracker.replace(previous.getId(), next);
        // Проверяем, что заявка с таким id имеет новые имя test2.
        assertThat(tracker.findById(previous.getId()).getName(), is("test2"));
    }

    @Test
    public void whenPrtMenu() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream def = System.out;
        System.setOut(new PrintStream(out));
        StubInput input = new StubInput(
                new String[] {"0"}
        );
        StubAction action = new StubAction();
        new StartUI().init(input, new Tracker(), new UserAction[] { action });
        String expect = new StringJoiner(System.lineSeparator(), "", System.lineSeparator())
                .add("Menu.")
                .add("0. Stub action")
                .toString();
        assertThat(new String(out.toByteArray()), is(expect));
        System.setOut(def);
    }

    @Test
    public void whenShowAll() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream def = System.out;
        System.setOut(new PrintStream(out));
        Tracker tracker = new Tracker();
        Item item = new Item("fix bug");
        tracker.add(item);
        ShowAll act = new ShowAll();
        act.execute(new StubInput(new String[]{}), tracker);
        String expect = new StringJoiner(System.lineSeparator(), "", System.lineSeparator())
                .add("\n=== Show all items ====")
                .add("Name: \"" + item.getName() + "\" ID Key: " + item.getId())
                .toString();
        assertThat(new String(out.toByteArray()), Matchers.is(expect));
        System.setOut(def);
    }

    @Test
    public void whenFindByName() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream def = System.out;
        System.setOut(new PrintStream(out));
        Tracker tracker = new Tracker();
        Item itemOne = new Item("one");
        tracker.add(itemOne);
        FindByName act = new FindByName();
        act.execute(new StubInput(new String[] {"one"}), tracker);
        String expect = new StringJoiner(System.lineSeparator(), "", System.lineSeparator())
                .add("Name: \"" + itemOne.getName() + "\" ID Key: " + itemOne.getId())
                .toString();
        assertThat(new String(out.toByteArray()), Matchers.is(expect));
        System.setOut(def);
    }
}