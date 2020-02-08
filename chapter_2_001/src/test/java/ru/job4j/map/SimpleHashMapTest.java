package ru.job4j.map;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import ru.job4j.list.SimpleStackContainer;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.hamcrest.Matchers.is;

public class SimpleHashMapTest {
 SimpleHashMap<String, Integer> map = new SimpleHashMap<>();

    @Test
    public void whenAddKeyThenGetItValue() throws Exception {
        Assert.assertTrue(map.insert("KEY ONE", 1));
        Assert.assertTrue(map.insert("KEY TWO", 2));
        Assert.assertTrue(map.insert("KEY THREE", 3));
        Assert.assertThat(map.get("KEY ONE"), is(1));
    }
    @Test
    public void whenAddEntryThenRewriteIt() throws Exception {
        map.insert("KEY ONE", 1);
        map.insert("KEY TWO", 2);
        map.insert("KEY THREE", 3);
        map.insert("KEY TWO", 4);
        Assert.assertThat(map.get("KEY TWO"), is(4));
    }

    @Test
    public void whenAddMoreThanArrayLengthReturnsTrue() {
        Assert.assertTrue(map.insert("A", 1));
        Assert.assertTrue(map.insert("B", 2));
        Assert.assertTrue(map.insert("C", 3));
        Assert.assertTrue(map.insert("D", 4));
        Assert.assertTrue(map.insert("E", 5));
        Assert.assertTrue(map.insert("F", 6));
        Assert.assertTrue(map.insert("G", 7));
        Assert.assertTrue(map.insert("H", 8));
        Assert.assertTrue(map.insert("I", 9));
        Assert.assertTrue(map.insert("J", 10));
        Assert.assertTrue(map.insert("K", 11));
        Assert.assertTrue(map.insert("L", 12));
        Assert.assertTrue(map.insert("M", 13));
        Assert.assertTrue(map.insert("N", 14));
        Assert.assertTrue(map.insert("O", 15));
        Assert.assertTrue(map.insert("P", 16));
        Assert.assertTrue(map.insert("Q", 17));
    }

    @Test (expected = Exception.class)
    public void whenGetNotExistedKeyThrowException() throws Exception {
        map.insert("KEY ONE", 1);
        map.insert("KEY TWO", 2);
        map.insert("KEY THREE", 3);
        map.get("KEY TWELVE");
    }

    @Test
    public void whenDeleteExistedKeyReturnsTrue() {
        map.insert("KEY ONE", 1);
        map.insert("KEY TWO", 2);
        map.insert("KEY THREE", 3);
        Assert.assertTrue(map.delete("KEY THREE"));
    }

    @Test
    public void whenDeleteNotExistedKeyReturnsFalse() {
        map.insert("KEY ONE", 1);
        map.insert("KEY TWO", 2);
        map.insert("KEY THREE", 3);
        Assert.assertFalse(map.delete("KEY TWELVE"));
    }

    @Test  (expected = Exception.class)
    public void whenDeleteExistedKeyThenTryToGetItThrowException() throws Exception {
        map.insert("KEY ONE", 1);
        map.insert("KEY TWO", 2);
        map.insert("KEY THREE", 3);
        map.delete("KEY THREE");
        map.get("KEY TWELVE");
    }

    @Test (expected = ConcurrentModificationException.class)
    public void whenCreateIteratorThenModifyList() {
        Iterator<Integer> iterator = map.iterator();
        map.insert("KEY ONE", 1);
        iterator.next();
    }
    @Test(expected = NoSuchElementException.class)
    public void whenIterateUntilThrowsException() {
        map.insert("KEY ONE", 1);
        map.insert("KEY TWO", 2);
        map.insert("KEY THREE", 3);
        Iterator<Integer> iterator = map.iterator();
        iterator.next();
        iterator.next();
        iterator.next();
        iterator.next();
    }
}
