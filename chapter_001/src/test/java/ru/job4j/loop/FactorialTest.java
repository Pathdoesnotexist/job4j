package ru.job4j.loop;

import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class FactorialTest {
    @Test
    public void whenCalculateFactorialForFiveThenOneHundreedTwenty() {
        int n = 5, exp = 120;
        int out = Factorial.calc(n);
        Assert.assertEquals(exp, out);

    }

    @Test
    public void whenCalculateFactorialForZeroThenOne() {
        int n = 0, exp = 1;
        int out = Factorial.calc(n);
        Assert.assertEquals(exp, out);
    }
}