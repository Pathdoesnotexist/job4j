package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class FindLoopTest {

    @Test
    public void caseFound1() {
        FindLoop find = new FindLoop();
        int[] input = new int[] {5, 10, 3};
        int value = 5;
        int result = find.indexOf(input, value);
        int expect = 0;
        assertThat(result, is(expect));
    }

    @Test
    public void caseFound2() {
        FindLoop find = new FindLoop();
        int[] input = new int[] {-2, 13, 543, 32, 0, -18, 2, 13, -8};
        int value = -8;
        int result = find.indexOf(input, value);
        int expect = 8;
        assertThat(result, is(expect));
    }

    @Test
    public void caseNotFound() {
        FindLoop find = new FindLoop();
        int[] input = new int[] {-2, 13, 543, 32, 0, -18, 2, 13, -8};
        int value = 10;
        int result = find.indexOf(input, value);
        int expect = -1;
        assertThat(result, is(expect));
    }
}