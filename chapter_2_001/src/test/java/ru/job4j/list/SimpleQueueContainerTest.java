package ru.job4j.list;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.hamcrest.Matchers.is;

public class SimpleQueueContainerTest {
    SimpleQueueContainer<Object> queue;

    @Before
    public void setUp() {
        queue = new SimpleQueueContainer<>();
        queue.push(1);
        queue.push(2);
        queue.push(3);
    }

    @Test
    public void whenPushElementThanPollIt() {
        queue.push(1000);
        Assert.assertThat(queue.poll(), is(1));
    }

    @Test
    public void whenPollReturnAddedInLIFOOrder() {
        Assert.assertThat(queue.poll(), is(1));
        Assert.assertThat(queue.poll(), is(2));
        Assert.assertThat(queue.poll(), is(3));
    }

    @Test (expected = ConcurrentModificationException.class)
    public void whenCreateIteratorThenModifyList() {
        Iterator<Object> iterator = queue.iterator();
        queue.push(1000);
        iterator.next();
    }

    @Test(expected = NoSuchElementException.class)
    public void whenIterateUntilThrowsException() {
        Iterator<Object> iterator = queue.iterator();
        iterator.next();
        iterator.next();
        iterator.next();
        iterator.next();
    }

    @Test
    public void whenIterateUntilLast() {
        Iterator<Object> iterator = queue.iterator();
        Assert.assertTrue(iterator.hasNext());
        iterator.next();
        Assert.assertTrue(iterator.hasNext());
        iterator.next();
        Assert.assertTrue(iterator.hasNext());
        iterator.next();
        Assert.assertFalse(iterator.hasNext());
    }
}