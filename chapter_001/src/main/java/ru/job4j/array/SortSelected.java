package ru.job4j.array;

public class SortSelected {
    public static int[] sort(int[] data) {
        for (int i = 0; i < data.length; i++) {
            int min = MinInRange.findMin(data, i, data.length - 1); //находим минимальный элемент
            int index = FindLoop.indexOfWithPoints(data, min, i, data.length); //находим его номер
            if (index != i) { //проверяем, что минимум - это не текущий элемент и требуется перестановка
                int temp = data[i];
                data[i] = min;
                data[index] = temp;
            }
        }
        return data;
    }
}


