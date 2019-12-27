package ru.job4j.iterator;

import java.util.Iterator;
import java.util.*;

/**
 * Итератор двумерного массива
 * @author Andrey Varshavsky
 * @version 1.0
 * @since 26.12.2019
 */
public class MatrixIterator implements Iterator<Integer> {
    private int[][] matrix;
    private int i = 0;
    private int j = 0;
    public MatrixIterator(int[][] matrix) {
        this.matrix = matrix;
    }

    @Override
    public boolean hasNext() {
        return i < matrix.length && j < matrix[i].length;
    }

    @Override
    public Integer next() {
        int result = matrix[i][j];
    if (hasNext()) {
        if (j < matrix[i].length - 1) {
            j++;
        } else {
            i++;
            j = 0;
        }
    }
        return result;
    }
}
