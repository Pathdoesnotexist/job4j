package ru.job4j.list;

import java.util.List;

public class ConvertList2Array {
    public int[][] toArray(List<Integer> list, int rows) {
        while (list.size() % rows != 0) {
            list.add(0);
        }
        int cells = list.size() / rows;
        int[][] array = new int[rows][cells];

        int i = 0;
        int j = 0;
        for (Integer listElement : list) {
            array[i][j] = listElement;
            if (j < cells - 1) {
                j++;
            } else {
                j = 0;
                i++;
            }
        }
        return array;
    }
}
