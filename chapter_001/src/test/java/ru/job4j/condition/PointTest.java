package ru.job4j.condition;

import org.junit.Assert;
import org.junit.Test;

public class PointTest {

    @Test
    public void distance() {
        int inX1 = 0;
        int inY1 = 0;
        int inX2 = 2;
        int inY2 = 0;
        double exp = 2;
        double out = Point.distance(inX1, inY1, inX2, inY2);
        Assert.assertEquals(exp, out, 0.01);
    }

    @Test
    public void distance2() {
        int inX1 = -3;
        int inY1 = -13;
        int inX2 = 2;
        int inY2 = 11;
        double exp = 24.51;
        double out = Point.distance(inX1, inY1, inX2, inY2);
        Assert.assertEquals(exp, out, 0.01);
    }




}
