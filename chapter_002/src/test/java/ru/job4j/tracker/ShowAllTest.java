package ru.job4j.tracker;

import org.hamcrest.Matchers;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.StringJoiner;
import static org.junit.Assert.*;

public class ShowAllTest {

    @Test
    public void whenCheckOutput() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream def = System.out;
        System.setOut(new PrintStream(out));
        Tracker tracker = new Tracker();
        Item item = new Item("fix bug");
        tracker.add(item);
        ShowAll act = new ShowAll();
        act.execute(new StubInput(new String[] {}), tracker);
        String expect = new StringJoiner(System.lineSeparator(), "", System.lineSeparator())
                .add("\n=== Show all items ====")
                .add("Name: \"" + item.getName() + "\" ID Key: " + item.getId())
                .toString();
        assertThat(new String(out.toByteArray()), Matchers.is(expect));
        System.setOut(def);
    }
}