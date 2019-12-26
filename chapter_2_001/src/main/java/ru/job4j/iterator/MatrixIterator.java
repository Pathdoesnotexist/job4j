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
    private int overallMatrixLength;
    private int pointer = 0;
    private int i = 0;
    private int j = 0;

    public MatrixIterator(int[][] matrix) {
        this.matrix = matrix;
        this.overallMatrixLength = (int) Arrays.stream(matrix).flatMapToInt(Arrays::stream).count();
    }

    @Override
    public boolean hasNext() {
        return pointer < overallMatrixLength;
    }

    @Override
    public Integer next() {
        int result;
        try {
            result = matrix[i][j];
            if (j < matrix[i].length - 1) {
                j++;
            } else {
                i++;
                j = 0;
            }
        } catch (ArrayIndexOutOfBoundsException ex) {
            System.out.println("No such element.");
            result = matrix[i - 1][j];
        }
        pointer++;
        return result;
    }
}
