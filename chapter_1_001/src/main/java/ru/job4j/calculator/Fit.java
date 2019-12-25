package ru.job4j.calculator;

public class Fit {
    public static double manWeight(double height) {
        return (height - 100) * 1.15;
    }

    public static double womanWeight(double height) {
        return (height - 110) * 1.15;
    }

    public static void main(String[] args) {
        double man = manWeight(178);
        System.out.println("Ideal weight for that man is " + Math.round(man) + " kg.");

        double woman = womanWeight(160);
        System.out.println("Ideal weight for that woman is " + Math.round(woman) + " kg.");
    }
}
