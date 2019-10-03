package ru.job4j.converter;

import org.junit.Assert;
import org.junit.Test;

public class ConverterTest {

    @Test
    public void rubleToEuro() {
        int in = 140;
        int expected = 2;
        int out = Converter.rubleToEuro(in);
        Assert.assertEquals(expected, out);
    }

    @Test
    public void rubleToDollar() {
        int in = 180;
        int expected = 3;
        int out = Converter.rubleToDollar(in);
        Assert.assertEquals(expected, out);
    }

    @Test
    public void euroToRouble() {
        int in = 70;
        int expected = 4900;
        int out = Converter.euroToRouble(in);
        Assert.assertEquals(expected, out);
    }

    @Test
    public void dollarToRouble() {
        int in = 100;
        int expected = 6000;
        int out = Converter.dollarToRouble(in);
        Assert.assertEquals(expected, out);
    }
}