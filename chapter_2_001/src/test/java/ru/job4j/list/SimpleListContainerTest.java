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
        listContainer.addLast("First");
        listContainer.addLast(125);
        listContainer.addLast(true);
        listContainer.addLast('&');
        listContainer.addLast(1.25);
    }

    @Test
    public void whenAddLastElementThanGetLast() {
        listContainer.addLast(1000);
        Assert.assertThat(listContainer.get(5), is(1000));
    }

    @Test
    public void whenAddFirstElementThanGetFirst() {
        listContainer.addFirst(1000);
        Assert.assertThat(listContainer.get(0), is(1000));
    }

    @Test
    public void whenDeleteFirstElementThanGetFirst() {
        listContainer.deleteFirst();
        Assert.assertThat(listContainer.get(0), is(125));
    }

    @Test
    public void whenDeleteLastElementThanGetLast() {
        listContainer.deleteLast();
        Assert.assertThat(listContainer.get(3), is('&'));
    }

    @Test (expected = ArrayIndexOutOfBoundsException.class)
    public void whenGetElementThanThrowException() {
        Assert.assertThat(listContainer.get(5), is(1000));
    }

    @Test (expected = ConcurrentModificationException.class)
    public void whenCreateIteratorThenModifyList() {
        Iterator<Object> iterator = listContainer.iterator();
        listContainer.addLast(1000);
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
