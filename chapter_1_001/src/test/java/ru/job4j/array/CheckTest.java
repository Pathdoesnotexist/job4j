package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class CheckTest {
    @Test
    public void case1() {
        Check check = new Check();
        boolean[] input = new boolean[] {true, true, true};
        boolean result = check.mono(input);
        assertThat(result, is(true));
    }

    @Test
    public void case2() {
        Check check = new Check();
        boolean[] input = new boolean[] {true, false, true};
        boolean result = check.mono(input);
        assertThat(result, is(false));
    }

    @Test
    public void case3() {
        Check check = new Check();
        boolean[] input = new boolean[] {false, false, false, false, false, false, false, false, false};
        boolean result = check.mono(input);
        assertThat(result, is(true));
    }

    @Test
    public void case4() {
        Check check = new Check();
        boolean[] input = new boolean[] {false, false, false, false, false, true};
        boolean result = check.mono(input);
        assertThat(result, is(false));
    }

    @Test
    public void case5() {
        Check check = new Check();
        boolean[] input = new boolean[] {false, false, false, false, false, false, false, false, true};
        boolean result = check.mono(input);
        assertThat(result, is(false));
    }

}