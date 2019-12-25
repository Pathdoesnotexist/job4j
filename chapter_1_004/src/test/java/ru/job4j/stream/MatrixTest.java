package ru.job4j.stream;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class MatrixTest {
    @Test
    public void test01() {
        Matrix wrap = new Matrix();
        Integer[][] myMatrix = wrap.createEmptyMatrix(5);
        wrap.fillMatrix(myMatrix);

        Integer[][] clone = myMatrix.clone();
        List<Integer> expected = new ArrayList<>();
        for (Integer[] i : clone) {
            expected.addAll(Arrays.asList(i));
        }
        Assert.assertThat((wrap.matrixInList(myMatrix).toString()), is(expected.toString()));
    }
}
