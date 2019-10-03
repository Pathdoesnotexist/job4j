package ru.job4j.converter;

public class Converter {
    public static int rubleToEuro (int value) {
        return value / 70;
    }

    public static int rubleToDollar (int value) {
        return value / 60;
    }

    public static int euroToRouble (int value) {
        return value * 70;
    }

    public static int dollarToRouble (int value) {
        return value * 60;
    }

    public static void main(String[] args) {
        int in = 140;
        int expected = 2;
        int out = rubleToEuro(in);
        boolean passed = expected == out;
        System.out.println("140 rubles are 2. Test result : " + passed);

        in = 240;
        expected = 4;
        out = rubleToDollar(in);
        passed = expected == out;
        System.out.println("240 rubles are 4. Test result : " + passed);

        in = 40;
        expected = 2800;
        out = euroToRouble(in);
        passed = expected == out;
        System.out.println("40 euro are 2800. Test result : " + passed);

        in = 73;
        expected = 4380;
        out = dollarToRouble(in);
        passed = expected == out;
        System.out.println("73 dollars are 4380. Test result : " + passed);
    }
}
