package ru.job4j.array;

import java.util.Arrays;

public class Square {
    public static int[] calculate(int bound) {
        int[] rst = new int[bound];
        for (int i = 0; i < rst.length; i++) {
            rst[i] = (int) Math.pow(i + 1, 2);
        }
        return rst;
    }
//    public static void main(String[] args) {
//        System.out.println(Arrays.toString(calculate( 5)));
//        System.out.println(Arrays.toString(calculate( 2)));
//        System.out.println(Arrays.toString(calculate( 10)));
//    }
}
