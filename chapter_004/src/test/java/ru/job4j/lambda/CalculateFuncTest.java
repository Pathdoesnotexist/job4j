package ru.job4j.lambda;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;


public class CalculateFuncTest {

       @Test
   public void whenLinearFunctionThenLinearResults() {
           CalculateFunc function = new CalculateFunc();
           List<Double> result = function.diapason(5, 8, x -> 2 * x + 1);
        List<Double> expected = Arrays.asList(11D, 13D, 15D);
        assertThat(result, is(expected));
        }

    @Test
    public void whenQuadraticFunctionThenLinearResults() {
        CalculateFunc function = new CalculateFunc();
        List<Double> result = function.diapason(5, 8, x -> Math.pow(x, 2) + 1);
        List<Double> expected = Arrays.asList(26D, 37D, 50D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenLogFunctionThenLinearResults() {
        CalculateFunc function = new CalculateFunc();
        List<Double> result = function.diapason(1000, 1001, x -> Math.log10(x) + 17);
        List<Double> expected = Collections.singletonList(20D);
        assertThat(result, is(expected));
    }
}
