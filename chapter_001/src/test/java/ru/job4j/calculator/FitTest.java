package ru.job4j.calculator;

import org.junit.Assert;
import org.junit.Test;


public class FitTest {

    @Test
    public void manWeight() {
        double in = 200;
        double exp = 115;
        double out = Fit.manWeight(in);
        Assert.assertEquals(exp, out, 0.01);
    }

    @Test
    public void womanWeight() {
        double in = 110;
        double exp = 0;
        double out = Fit.womanWeight(in);
        Assert.assertEquals(exp, out, 0.01);
    }
}
