package ru.job4j.сomparisons;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.lessThan;
import static org.hamcrest.MatcherAssert.assertThat;

public class StringsCompareTest {
    @Test
    public void whenStringsAreEqualThenZero () {
        ListCompare compare = new ListCompare();
        int rst = compare.compare(
                "Ivanov",
                "Ivanov"
        );

        String a =  "Ivanov";
        String b =  "Ivanov";
        System.out.println(a + " vs " + b + " ожидаем =");
        System.out.println(a.compareTo(b));

        assertThat(rst, is(0));
    }

    @Test
    public void whenLeftLessThanRightResultShouldBeNegative () {
        ListCompare compare = new ListCompare();
        int rst = compare.compare(
                "Ivanov",
                "Ivanova"
        );
        String a =  "Ivanov";
        String b =  "Ivanova";
        System.out.println(a + " vs " + b + " ожидаем -");
        System.out.println(a.compareTo(b));

        assertThat(rst, lessThan(0));
    }

    @Test
    public void whenLeftGreaterThanRightResultShouldBePositive () {
        ListCompare compare = new ListCompare();
        int rst = compare.compare(
                "Petrov",
                "Ivanova"
        );

        String a =  "Petrov";
        String b =  "Ivanova";
        System.out.println(a + " vs " + b + " ожидаем +");
        System.out.println(a.compareTo(b));

        assertThat(rst, greaterThan(0));
    }

    @Test
    public void secondCharOfLeftGreaterThanRightShouldBePositive(){
        ListCompare compare = new ListCompare();
        int rst = compare.compare(
                "Petrov",
                "Patrov"
        );

        String a =  "Petrov";
        String b =  "Patrov";
        System.out.println(a + " vs " + b + " ожидаем +");
        System.out.println(a.compareTo(b));

        assertThat(rst, greaterThan(0));
    }

    @Test
    public void secondCharOfLeftLessThanRightShouldBeNegative(){
        ListCompare compare = new ListCompare();
        int rst = compare.compare(
                "Patrova",
                "Petrov"
        );

        String a =  "Patrova";
        String b =  "Petrov";
        System.out.println(a + " vs " + b + " ожидаем -");
        System.out.println(a.compareTo(b));

        assertThat(rst, lessThan(0));
    }
}