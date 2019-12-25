package ru.job4j.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class CalculateFunc {
    List<Double> diapason(int start, int end, Function<Double, Double> func) {
        List<Double> result = new ArrayList<>();
        for (int i = start; i < end; i++) {
            result.add(func.apply((double) i));
        }
    return result;
    }

    public static void main(String[] args) {
        CalculateFunc function = new CalculateFunc();
        List<Double> result = function.diapason(5, 8, x -> 2 * x + 1);
        System.out.println("Линейная для 5, 6, 7 (2x+1): " + result);

        List<Double> result2 = function.diapason(5, 8, x -> Math.pow(x, 2) + 1);
        System.out.println("Квадратичная для 5, 6, 7 (x^2+1): " + result2);

        List<Double> result3 = function.diapason(100, 101, x -> Math.log10(x) + 1);
        System.out.println("Логарифмическая для 100 (log10(x)+1): " + result3);
    }


}
