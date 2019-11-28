package ru.job4j.tracker;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.function.Consumer;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class ValidateInputTest {

    @Test
    public void whenInvalidInput() {
        Consumer<String> output = System.out::println;
        ByteArrayOutputStream mem = new ByteArrayOutputStream();
        PrintStream out = System.out;
        String expected = "Please enter a valid data " + System.lineSeparator();
        System.setOut(new PrintStream(mem));
        ValidateInput input = new ValidateInput(
                new StubInput(new String[] {"invalid", "1"})
        );
        input.askInt("Enter", 1);
        assertThat(
                mem.toString(),
                is(expected)
        );
        System.setOut(out);
    }
}