package ru.job4j.array;

public class Turn {
    public int[] back(int[] array) {
        double oddEvenLength = Math.floor(array.length / 2);
        for (int i = 0; i < oddEvenLength; i++) {
            int temp = array[i];
            array[i] = array[array.length - (i + 1)];
            array[array.length - (i + 1)] = temp;
        }
        return array;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 4};
        System.out.println(arr[4]);
    }

}

