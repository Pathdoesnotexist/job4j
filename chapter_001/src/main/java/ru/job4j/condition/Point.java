package ru.job4j.condition;

public class Point {

    static double distance(int x1, int y1, int x2, int y2) {
        return Math.sqrt(Math.pow((x2 - x1), 2) + Math.pow((y2 - y1), 2));
    }

    public static void main(String[] args) {
        double result = distance(0, 0, 2, 0);
        System.out.println("result (0, 0) to (2, 0) " + result);
        result = distance(10, -5, 5, 1);
        System.out.println("result (10, -5) to (5, 1) " + result);
        result = distance(-3, -13, 2, 11);
        System.out.println("result (-3, -13) to (2, 11) " + result);
    }
}
