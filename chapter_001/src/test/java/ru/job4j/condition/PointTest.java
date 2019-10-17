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

    @Test
    public void distance3d() {
        Point first3d = new Point(10, -5, 0);
        Point second3d = new Point(5, 1, 4);
        double exp = 7.8;
        double out = first3d.distance(second3d);
        Assert.assertEquals(exp, out, 0.02);
    }



}
