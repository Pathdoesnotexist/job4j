package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SortSelectedTest {
    @Test
    public void whenSort1() {
        int[] input = new int[] {3, 4, 1, 2, 5};
        int[] result = SortSelected.sort(input);
        int[] expect = new int[] {1, 2, 3, 4, 5};
        assertThat(result, is(expect));
    }

    @Test
    public void whenSort2() {
        int[] input = new int[] {0, -458, 1058, 12, -25};
        int[] result = SortSelected.sort(input);
        int[] expect = new int[] {-458, -25, 0, 12, 1058};
        assertThat(result, is(expect));
    }

    @Test
    public void whenSort3() {
        int[] input = new int[] {36, -4, 1};
        int[] result = SortSelected.sort(input);
        int[] expect = new int[] {-4, 1, 36};
        assertThat(result, is(expect));
    }

    @Test
    public void whenSort4() {
        int[] input = new int[] {0, 0, 0, 1, 0, 0, -1};
        int[] result = SortSelected.sort(input);
        int[] expect = new int[] {-1, 0, 0, 0, 0, 0, 1};
        assertThat(result, is(expect));
    }
}