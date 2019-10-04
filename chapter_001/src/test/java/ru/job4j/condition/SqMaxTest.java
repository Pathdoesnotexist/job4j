package ru.job4j.condition;

import org.junit.Assert;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SqMaxTest {

    @Test
    public void whenFirstMax (){
        SqMax check = new SqMax();
        int result = check.max(5, 3, 2, -7);
        Assert.assertThat(result, is(5));
    }

    @Test
    public void whenSecondMax (){
        SqMax check = new SqMax();
        int result = check.max(0, 10, 3, 9);
        Assert.assertThat(result, is(10));
    }

    @Test
    public void whenThirdMax (){
        SqMax check = new SqMax();
        int result = check.max(8, 8, 88, 8);
        Assert.assertThat(result, is(88));
    }
}
