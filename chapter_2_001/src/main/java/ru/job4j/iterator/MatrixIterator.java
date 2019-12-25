package ru.job4j.iterator;

import java.util.Iterator;
import java.util.*;

public class MatrixIterator implements Iterator<Integer> {
    private int[][] matrix;
    private int index = 0;

    public MatrixIterator(int[][] matrix) {
        this.matrix = matrix;
    }

    @Override
    public boolean hasNext() {
        return flatMatrix(matrix).size() > index;
    }

    @Override
    public Integer next() {
        return flatMatrix(matrix).get(index++);
    }

    private List<Integer> flatMatrix(int[][] matrix) {
        List<Integer> answer = new ArrayList<>();
        for (int[] innerArray : matrix) {
            for (int element : innerArray) {
                answer.add(element);
            }
        }
        return answer;
    }
}
