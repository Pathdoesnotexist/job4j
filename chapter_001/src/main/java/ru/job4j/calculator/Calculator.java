package ru.job4j.calculator;

/**
 * Calculate result of + , - , / , * two values
 * @author Andrey V
 */

public class Calculator {

    /**
     * addition method
     * @param first First value
     * @param second Second value
     */
    public static void add(double first, double second) {
        double result = first + second;
        System.out.println(first + " + " + second + " = " + result);
    }

    /**
     * subtraction  method
     * @param first First value
     * @param second Second value
     */
    public static void subtract(double first, double second) {
        double result = first - second;
        System.out.println(first + " - " + second + " = " + result);
    }

    /**
     * multiplication  method
     * @param first First value
     * @param second Second value
     */
    public static void multiply(double first, double second) {
        double result = first * second;
        System.out.println(first + " * " + second + " = " + result);
    }

    /**
     * division  method
     * @param first First value
     * @param second Second value
     */
    public static void div(double first, double second) {
        double result = first / second;
        System.out.println(first + " / " + second + " = " + result);
    }

    /**
     * Main. Call of add, div, multiply, subtract methods
     * @param args - ars
     */
    public static void main(String[] args) {
        add(1, 1);
        div(4, 2);
        multiply(2, 1);
        subtract(10, 5);
    }


}

