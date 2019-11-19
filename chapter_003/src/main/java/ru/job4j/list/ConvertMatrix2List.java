package ru.job4j.list;

import java.util.ArrayList;
import java.util.List;

public class ConvertMatrix2List {
    public List<Integer> toList(int[][] array) {
        List<Integer> list = new ArrayList<>();
        int i = 0;
        int j = 0;

        while (i < array.length && j < array[i].length) {
            list.add(array[i][j]);
            if (j < array[i].length - 1) {
                j++;
            } else {
                j = 0;
                i++;
            }
        }
        return list;
    }
}
