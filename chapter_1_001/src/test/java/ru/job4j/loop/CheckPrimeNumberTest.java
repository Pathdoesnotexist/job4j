package ru.job4j.loop;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class CheckPrimeNumberTest {
    @Test
    public void when5() {
        CheckPrimeNumber prime = new CheckPrimeNumber();
        boolean rsl = prime.check(5);
        assertThat(rsl, is(true));
    }

    @Test
    public void when4() {
        CheckPrimeNumber prime = new CheckPrimeNumber();
        boolean rsl = prime.check(4);
        assertThat(rsl, is(false));
    }

    @Test
    public void when17() {
        CheckPrimeNumber prime = new CheckPrimeNumber();
        boolean rsl = prime.check(17);
        assertThat(rsl, is(true));
    }

    @Test
    public void when25() {
        CheckPrimeNumber prime = new CheckPrimeNumber();
        boolean rsl = prime.check(25);
        assertThat(rsl, is(false));
    }
}