package ru.job4j.condition;

import org.junit.Assert;
import org.junit.Test;

public class PointTest {

    @Test
    public void distance() {
        Point first = new Point(0,0);
        Point second = new Point(0,2);
        double exp = 2;
        double out = first.distance(second);
        Assert.assertEquals(exp, out, 0.01);
    }

    @Test
    public void distance2() {
        Point first = new Point(-3,-13);
        Point second = new Point(2,11);
        double exp = 24.51;
        double out = first.distance(second);
        Assert.assertEquals(exp, out, 0.01);
    }




}
