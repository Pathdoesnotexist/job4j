package ru.job4j.tracker;

import org.hamcrest.Matchers;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.StringJoiner;
import static org.junit.Assert.*;

public class FindByNameTest {

    @Test
    public void whenCheckOutput() {
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