package ru.job4j.sort;

import ru.job4j.array.SortSelected;

import java.util.Arrays;

public class Merge {
    public int[] merge(int[] left, int[] right) {
        int[] result = new int[left.length + right.length];
        int index = 0, ri = 0, li = 0;
        while (index < result.length) {
            if (li < left.length && ri < right.length && left[li] <= right[ri]) {
                result[index] = left[li];
                li++;
            } else if (li < left.length && ri < right.length && right[ri] < left[li]) {
                result[index] = right[ri];
                ri++;
            } else if (li == left.length) {
                result[index] = right[ri];
                ri++;
            } else {
                result[index] = left[li];
                li++;
            }
            index++;
        }
        return result;
    }

    public static void main(String[] args) {
        Merge process = new Merge();
        int[] rsl = process.merge(
                new int[] {1, 3, 5, 25, 47, 49},
                new int[] {2, 4, 6, 100}
        );
        System.out.println(Arrays.toString(rsl));

        Merge process2 = new Merge();
        int[] rsl2 = process2.merge(
                new int[] {1, 3, 5},
                new int[] {2, 4}
        );
        System.out.println(Arrays.toString(rsl2));
    }
}
