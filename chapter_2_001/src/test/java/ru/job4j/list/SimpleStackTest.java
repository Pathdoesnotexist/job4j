package ru.job4j.list;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.is;

public class SimpleStackTest {
    SimpleStack<Integer> stack;

    @Before
    public void setUp() {
        stack = new SimpleStack<>();
        stack.add(1);
        stack.add(2);
        stack.add(3);
    }

    @Test
    public void whenPushElementThanPollit() {
        stack.push(1000);
        Assert.assertThat(stack.poll(), is(1000));
    }

    @Test
    public void whenPollThreeTimesAndLastIsOne() {
        stack.poll();
        stack.poll();
        Assert.assertThat(stack.poll(), is(1));
    }
}
