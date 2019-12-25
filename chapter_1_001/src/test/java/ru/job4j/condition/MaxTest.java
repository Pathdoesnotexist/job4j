package ru.job4j.condition;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class MaxTest {
    @Test
    public void whenMax2() {
        int result = Max.maximum(1, 2);
        assertThat(result, is(2));
    }

    @Test
    public void whenMax5() {
        int result = Max.maximum(5, 1);
        assertThat(result, is(5));
    }

    @Test
    public void whenMax3() {
        int result = Max.maximum(3, 3);
        assertThat(result, is(3));
    }

    @Test
    public void whenMax6() {
        int result = Max.maximum(3, 6, 1);
        assertThat(result, is(6));
    }

    @Test
    public void whenMax0() {
        int result = Max.maximum(-6, -1, 0);
        assertThat(result, is(0));
    }
}
