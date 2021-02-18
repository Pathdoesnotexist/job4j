package ru.job4j.pojo;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Assert;
import org.junit.Test;

public class LicenseTest {

    @Test
    public void eqName() {
        License first = new License();
        first.setCode("audio");
        License second = new License();
        second.setCode("audio");
        assertThat(first, is(second));
    }
    @Test
    public void WhenFalseWithDifferentCountOfParameters() {
        License first = new License();
        first.setCode("audio");
        first.setModel("SD-513");
        License second = new License();
        second.setCode("audio");
        Assert.assertNotEquals(first, second);
    }
    @Test
    public void WhenFalseWithDifferentParameters() {
        License first = new License();
        first.setCode("audio");
        first.setModel("SD-513");
        License second = new License();
        second.setCode("audio");
        first.setModel("SD-512");
        Assert.assertNotEquals(first, second);
    }
}
