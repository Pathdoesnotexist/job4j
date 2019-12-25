package ru.job4j.loop;

import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class CounterTest {
    @Test
    public void test01() {
        int start = 1, finish = 10, exp = 30;
        int out = Counter.add(start, finish);
        Assert.assertEquals(exp, out);
    }

    @Test
    public void test02() {
        int start = 11, finish = 10, exp = 0;
        int out = Counter.add(start, finish);
        Assert.assertEquals(exp, out);
    }

    @Test
    public void test03() {
        int start = 14, finish = 43, exp = 420;
        int out = Counter.add(start, finish);
        Assert.assertEquals(exp, out);
    }

    @Test
    public void test04() {
        int start = -100, finish = -50, exp = -1950;
        int out = Counter.add(start, finish);
        Assert.assertEquals(exp, out);
    }

}
