package ru.job4j.array;

public class Defragment {
    public static String[] compress(String[] array) {
        int content = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] != null) {
                array[content] = array[i];
                content++;
            }
            System.out.print(array[i] + " ");
        }
        for (int i = content; i < array.length; i++){
            array[i] = null;
        }
        return array;
    }

    public static void main(String[] args) {
        String[] input = {"I", null, "wanna", null, "be", null, "compressed"};
        String[] compressed = compress(input);
        System.out.println("\nПосле трансформации: ");
        for (int index = 0; index < compressed.length; index++) {
            System.out.print(compressed[index] + " ");
        }
        System.out.println();

        String[] inputTwo = {"I", "wanna", "be", null, null, null, "compressed"};
        String[] compressedTwo = compress(inputTwo);
        System.out.println("\nПосле трансформации: ");
        for (int index = 0; index < compressedTwo.length; index++) {
            System.out.print(compressedTwo[index] + " ");
        }
        System.out.println();
    }
}