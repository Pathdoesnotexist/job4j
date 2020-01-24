package ru.job4j.list;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.is;

public class SimpleListContainerTest {
    SimpleListContainer<Object> listContainer;

    @Before
    public void setUp() {
        listContainer = new SimpleListContainer<>();
        listContainer.add("First");
        listContainer.add(125);
        listContainer.add(true);
        listContainer.add('&');
        listContainer.add(1.25);
    }

    @Test
    public void whenAddElementThanGetIt() {
        listContainer.add(1000);
        Assert.assertThat(listContainer.get(5), is(1000));
    }

    @Test (expected = ArrayIndexOutOfBoundsException.class)
    public void whenGetElementThanThrowException() {
        Assert.assertThat(listContainer.get(5), is(1000));
    }

    @Test (expected = ConcurrentModificationException.class)
    public void whenCreateIteratorThenModifyList() {
        Iterator<Object> iterator = listContainer.iterator();
        listContainer.add(1000);
        iterator.next();
    }

    @Test(expected = NoSuchElementException.class)
    public void whenIterateUntilThrowsException() {
        Iterator<Object> iterator = listContainer.iterator();
        iterator.next();
        iterator.next();
        iterator.next();
        iterator.next();
        iterator.next();
        iterator.next();
    }

    @Test
    public void whenIterateUntilLast() {
        Iterator<Object> iterator = listContainer.iterator();
        Assert.assertTrue(iterator.hasNext());
        iterator.next();
        Assert.assertTrue(iterator.hasNext());
        iterator.next();
        Assert.assertTrue(iterator.hasNext());
        iterator.next();
        Assert.assertTrue(iterator.hasNext());
        iterator.next();
        Assert.assertTrue(iterator.hasNext());
        iterator.next();
        Assert.assertFalse(iterator.hasNext());
    }

}
