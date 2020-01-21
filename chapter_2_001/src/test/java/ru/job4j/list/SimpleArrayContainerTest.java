package ru.job4j.list;

import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class SimpleArrayContainerTest {
    private SimpleArrayContainer<Integer> list;

    @Before
    public void beforeTest() {
        list = new SimpleArrayContainer<>(3);
        list.add(11);
        list.add(22);
        list.add(33);
    }

    @Test
    public void whenAddThreeElementsThenUseGetThirdResult() {
        assertThat(list.get(2), is(33));
    }

    @Test (expected = ArrayIndexOutOfBoundsException.class)
    public void whenTryToGetOutOfBoundsElementThrowsException() {
        list.get(3);
    }

    @Test
    public void whenAddFourElementsThenSixthElementIsNull() {
        list.add(44);
        assertThat(list.get(5), is((Object) null));
    }

    @Test (expected = ConcurrentModificationException.class)
    public void whenAddThreeThanCreateIteratorThenAddOneThrowsException() {
        Iterator<Integer> iter = list.iterator();
        list.add(44);
        iter.next();
    }

    @Test
    public void whenIterateThreeTimesAndHasNextReturnFalse() {
        Iterator<Integer> iter = list.iterator();
        iter.next();
        iter.next();
        iter.next();
        Assert.assertFalse(iter.hasNext());
    }

    @Test (expected = NoSuchElementException.class)
    public void whenIterateFourTimesThrowsException() {
        Iterator<Integer> iter = list.iterator();
        iter.next();
        iter.next();
        iter.next();
        iter.next();
    }
}
