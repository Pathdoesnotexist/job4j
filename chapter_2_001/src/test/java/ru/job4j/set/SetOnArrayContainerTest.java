package ru.job4j.set;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;


public class SetOnArrayContainerTest {
    private SetOnArrayContainer<Integer> set;

    @Before
    public void beforeTest() {
        set = new SetOnArrayContainer<>(3);
        set.add(11);
        set.add(22);
        set.add(33);
    }

    @Test
    public void whenAddUniqueElementReturnTrue() {
        Assert.assertTrue(set.add(55));
    }
    @Test
    public void whenAddNonUniqueElementReturnFalse() {
        Assert.assertTrue(set.add(55));
        Assert.assertFalse(set.add(11));
    }

    @Test (expected = ConcurrentModificationException.class)
    public void whenAddThreeThanCreateIteratorThenAddOneThrowsException() {
        Iterator<Integer> iter = set.iterator();
        set.add(44);
        iter.next();
    }

    @Test
    public void whenIterateThreeTimesAndHasNextReturnFalse() {
        Iterator<Integer> iter = set.iterator();
        iter.next();
        iter.next();
        iter.next();
        Assert.assertFalse(iter.hasNext());
    }

    @Test (expected = NoSuchElementException.class)
    public void whenIterateFourTimesThrowsException() {
        Iterator<Integer> iter = set.iterator();
        iter.next();
        iter.next();
        iter.next();
        iter.next();
    }
}
