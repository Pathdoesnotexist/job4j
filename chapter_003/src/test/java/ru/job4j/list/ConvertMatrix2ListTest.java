package ru.job4j.list;

import org.junit.Test;
import java.util.Arrays;
import java.util.List;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ConvertMatrix2ListTest {
    @Test
    public void when2on2ArrayThenList4() {
        ConvertMatrix2List list = new ConvertMatrix2List();
        int[][] input = {
                {1, 2},
                {3, 4}
        };
        List<Integer> expect = Arrays.asList(
                1, 2, 3, 4
        );
        List<Integer> result = list.toList(input);
        assertThat(result, is(expect));
    }

    @Test
    public void when2on4ArrayThenList4() {
        ConvertMatrix2List list = new ConvertMatrix2List();
        int[][] input = {
                {1, 2},
                {3, 4},
                {5, 6},
                {7, 8}
        };
        List<Integer> expect = Arrays.asList(
                1, 2, 3, 4, 5, 6, 7, 8
        );
        List<Integer> result = list.toList(input);
        assertThat(result, is(expect));
    }

    @Test
    public void when3on3ArrayThenList4() {
        ConvertMatrix2List list = new ConvertMatrix2List();
        int[][] input = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 0, 0}
        };
        List<Integer> expect = Arrays.asList(
                1, 2, 3, 4, 5, 6, 7, 0, 0
        );
        List<Integer> result = list.toList(input);
        assertThat(result, is(expect));
    }

    @Test
    public void whenRandomArrayThenListOf10() {
        ConvertMatrix2List list = new ConvertMatrix2List();
        int[][] input = {
                {1, 2, 3, 0, 4},
                {5, 6},
                {7, 8, 0}
        };
        List<Integer> expect = Arrays.asList(
                1, 2, 3, 0, 4, 5, 6, 7, 8, 0
        );
        List<Integer> result = list.toList(input);
        assertThat(result, is(expect));
    }
    @Test
    public void whenRandomArrayThenListOf6() {
        ConvertMatrix2List list = new ConvertMatrix2List();
        int[][] input = {
                {1, 2},
                {3, 4, 5, 6}
        };
        List<Integer> expect = Arrays.asList(
                1, 2, 3, 4, 5, 6
        );
        List<Integer> result = list.toList(input);
        assertThat(result, is(expect));
    }
}