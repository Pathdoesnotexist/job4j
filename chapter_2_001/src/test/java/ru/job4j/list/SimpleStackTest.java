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
        stack.push(1);
        stack.push(2);
        stack.push(3);
    }

    @Test
    public void whenPushElementThanPollIt() {
        stack.push(1000);
        Assert.assertThat(stack.poll(), is(1000));
    }

    @Test
    public void whenPollReturnAddedInLIFOOrder() {
        Assert.assertThat(stack.poll(), is(3));
        Assert.assertThat(stack.poll(), is(2));
        Assert.assertThat(stack.poll(), is(1));
    }
}
