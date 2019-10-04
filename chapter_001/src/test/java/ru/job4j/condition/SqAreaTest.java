package ru.job4j.condition;

import org.junit.Assert;
import org.junit.Test;

public class SqAreaTest {

@Test
    public void test01() {
        int inP = 4;
        int inK = 1;
        double exp = 1.0;
        double out = SqArea.square(inP, inK);
        Assert.assertEquals(exp, out, 0.01);
    }

    @Test
    public void test02() {
        int inP = 12;
        int inK = 2;
        double exp = 8.0;
        double out = SqArea.square(inP, inK);
        Assert.assertEquals(exp, out, 0.01);
    }


}
