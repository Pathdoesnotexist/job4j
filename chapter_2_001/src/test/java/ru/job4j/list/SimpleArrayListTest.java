package ru.job4j.list;

import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class SimpleArrayListTest {

    private SimpleArrayList<Integer> list;

    @Before
    public void beforeTest() {
        list = new SimpleArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
    }

    @Test
    public void whenAddThreeElementsThenUseGetOneResultTwo() {
        assertThat(list.get(1), is(2));
    }

    @Test
    public void whenAddThreeElementsThenUseGetZeroResultThree() {
        assertThat(list.get(0), is(3));
    }

    @Test
    public void whenAddThreeElementsThenUseGetSizeResultThree() {
        assertThat(list.getSize(), is(3));
    }

    @Test
    public void whenDeleteFirstElementThenUseGetFirstResultTwo() throws Exception {
        list.delete();
        assertThat(list.get(0), is(2));
    }
    @Test
    public void whenDeleteFirstReturnThree() throws Exception {
        Assert.assertThat(list.delete(), is (3));
    }

    @Test
    public void whenDeleteTwoElementsThenUseGetSizeResultOne() throws Exception {
        list.delete();
        list.delete();
        assertThat(list.getSize(), is(1));
    }

    @Test (expected = Exception.class)
    public void whenDeleteAllPlusOneElementsThrowsException() throws Exception {
        list.delete();
        list.delete();
        list.delete();
        list.delete();
    }
}
