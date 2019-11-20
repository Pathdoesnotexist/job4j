package ru.job4j.condition;

import org.junit.Assert;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class TriangleTest {
    @Test
    public void whenTriangle() {
        Point a = new Point(0, 2);
        Point b = new Point(1, 4);
        Point c = new Point(4, 0);
        Triangle abc = new Triangle(a, b, c);
        boolean exist = abc.exist();
        double p = abc.period();
        double s = abc.area();
        double pOut = 11.70;
        double sOut = 5.0;
        assertThat(exist, is(true));
        Assert.assertEquals(sOut, s, 0.01);
        Assert.assertEquals(pOut, p, 0.01);
    }

    @Test
    public void whenPoint() {
        Point a = new Point(0, 0);
        Point b = new Point(0, 0);
        Point c = new Point(0, 0);
        Triangle abc = new Triangle(a, b, c);
        boolean exist = abc.exist();
        double p = abc.period();
        double s = abc.area();
        double pOut = -1;
        double sOut = -1;
        assertThat(exist, is(false));
        Assert.assertEquals(sOut, s, 0.01);
        Assert.assertEquals(pOut, p, 0.01);
    }

    @Test
    public void whenLineOne() {
        Point a = new Point(0, 1);
        Point b = new Point(3, 8);
        Point c = new Point(0, 1);
        Triangle abc = new Triangle(a, b, c);
        boolean exist = abc.exist();
        double p = abc.period();
        double s = abc.area();
        double pOut = -1;
        double sOut = -1;
        assertThat(exist, is(false));
        Assert.assertEquals(sOut, s, 0.01);
        Assert.assertEquals(pOut, p, 0.01);
    }

    @Test
    public void whenLineTwo() {
        Point a = new Point(0, 0);
        Point b = new Point(1, 3);
        Point c = new Point(2, 6);
        Triangle abc = new Triangle(a, b, c);
        boolean exist = abc.exist();
        double p = abc.period();
        double s = abc.area();
        double pOut = -1;
        double sOut = -1;
        assertThat(exist, is(false));
        Assert.assertEquals(sOut, s, 0.01);
        Assert.assertEquals(pOut, p, 0.01);
    }
}