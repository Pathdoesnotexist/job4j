package ru.job4j.list;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.hamcrest.Matchers.is;

public class SimpleStackContainerTest {
    SimpleStackContainer<Object> stack;

    @Before
    public void setUp() {
        stack = new SimpleStackContainer<>();
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
