package ru.job4j.generics;

import java.util.Iterator;
import java.util.NoSuchElementException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class SimpleArrayTest {
    SimpleArray<Object> simpleArray;

    @Before
    public void setUp() {
        simpleArray = new SimpleArray<>(5);
        simpleArray.add("First");
        simpleArray.add(125);
        simpleArray.add(true);
        simpleArray.add('&');
        simpleArray.add(1.25);
    }

    @Test
    public void whenAddElementToFilledArrayReturnFalse() {
        Assert.assertFalse(simpleArray.add("Ka-boom!"));
    }

    @Test
    public void whenDeleteElementFromFilledThenAddReturnTrue() {
        simpleArray.remove(0);
        Assert.assertTrue(simpleArray.add("AddMe"));
    }

    @Test
    public void whenSetElementReturnFalse() {
        Assert.assertFalse(simpleArray.set(6, "f"));
    }

    @Test
    public void whenSetElementReturnTrue() {
        Assert.assertTrue(simpleArray.set(1, "f"));
    }

    @Test
    public void whenDeleteOutOfRangeReturnFalse() {
        Assert.assertFalse(simpleArray.remove(6));
    }

    @Test
    public void when3rdIsBoolean() {
        Assert.assertTrue((boolean) simpleArray.get(2));
    }

    @Test
    public void whenReplaceStringToBooleanThenBooleanToString() {
        Assert.assertThat(simpleArray.get(0), is("First"));
        Assert.assertTrue((boolean) simpleArray.get(2));
        simpleArray.set(0, false);
        simpleArray.set(2, "Third");
        Assert.assertFalse((boolean) simpleArray.get(0));
        Assert.assertThat(simpleArray.get(2), is("Third"));
    }
    @Test
    public void whenDeleteLastShouldGetNull() {
        simpleArray.remove(4);
        Assert.assertNull(simpleArray.get(4));
    }

    @Test
    public void whenDeleteThreeElementsAndThirdShouldGetNull() {
        simpleArray.remove(2);
        simpleArray.remove(2);
        simpleArray.remove(2);
        Assert.assertNull(simpleArray.get(3));
    }

    @Test
    public void whenDeleteThreeThenDeleteEmptyShouldReturnFalse() {
        simpleArray.remove(2);
        simpleArray.remove(2);
        simpleArray.remove(2);
        Assert.assertFalse(simpleArray.remove(4));
    }

    @Test
    public void whenDeleteFirstAndFirstShouldBeInt() {
        simpleArray.remove(0);
        Assert.assertThat(simpleArray.get(0), is(125));
    }
    @Test
    public void whenIterateAllElements() {
        Iterator<Object> iterator = simpleArray.iterator();
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

    @Test(expected = NoSuchElementException.class)
    public void whenIterateUntilThrowsException() {
        Iterator<Object> iterator = simpleArray.iterator();
        iterator.next();
        iterator.next();
        iterator.next();
        iterator.next();
        iterator.next();
        iterator.next();
    }
}
