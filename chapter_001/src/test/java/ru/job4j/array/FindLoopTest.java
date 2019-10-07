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
    public void caseNotFound1() {
        FindLoop find = new FindLoop();
        int[] input = new int[] {-2, 13, 543, 32, 0, -18, 2, 13, -8};
        int value = 10;
        int result = find.indexOf(input, value);
        int expect = -1;
        assertThat(result, is(expect));
    }

    @Test
    public void caseFoundWithPoints1() {
        int[] input = new int[] {5, 2, 10, 2, 4};
        int value = 2;
        int start = 2;
        int finish = 4;
        int result = FindLoop.indexOfWithPoints(input, value, start, finish);
        int expect = 3;
        assertThat(result, is(expect));
    }

    @Test
    public void caseFoundWithPoints2() {
        FindLoop find = new FindLoop();
        int[] input = new int[] {-2, 13, 543, 32, 0, -8, 2, 13, -18};
        int value = -8;
        int start = 3;
        int finish = 6;
        int result = FindLoop.indexOfWithPoints(input, value, start, finish);
        int expect = 5;
        assertThat(result, is(expect));
    }

    @Test
    public void caseNotFoundWithPoints1() {
        FindLoop find = new FindLoop();
        int[] input = new int[] {-2, 13, 543, 32, 0, -18, 2, 13, -8};
        int value = 10;
        int start = 1;
        int finish = 7;
        int result = FindLoop.indexOfWithPoints(input, value, start, finish);
        int expect = -1;
        assertThat(result, is(expect));
    }

}