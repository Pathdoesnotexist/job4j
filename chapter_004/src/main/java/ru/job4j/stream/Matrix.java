package ru.job4j.stream;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Matrix {
    /**
     * Создание матрицы из массивов заданного размера
     * @param size размер матрицы
     * @return пустую матрицу массивов
     */
    public Integer[][] createEmptyMatrix(int size) {
        return new Integer[size][size];
    }
    /**
     * Заполнение матрицы случайными значениями от 0 до 10
     * @param matrix пустая матрица, которую надо заполнить
     */
    public void fillMatrix (Integer[][] matrix) {
        for (Integer[] inner : matrix) {
            for(int j = 0; j < inner.length; j++) {
                inner[j] = (int) Math.round(Math.random() * 10);
            }
        }
    }
    /**
     * Преобразование всех значений матрицы в список
     * @param matrix матрица значений
     * @return списолк значений
     */
    public List<Integer> matrixInList (Integer[][] matrix) {
        return Arrays.stream(matrix).flatMap(Stream::of).collect(Collectors.toList()); // x -> Stream.of(x) == Stream::of
    }

}
