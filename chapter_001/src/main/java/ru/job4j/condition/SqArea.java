package ru.job4j.condition;

public class SqArea {
    public static double square(int p, int k){
        double h = (p /2) / (k + 1);
        double L = h * k;
        return h * L;
        //return (((p /2) / (k + 1)) * k) * ((p /2) / (k + 1));
    }

    public static void main(String[] args){
        double result1 = square(4, 1);
        System.out.println(" p = 4, k = 1, s = " + result1);
        double result2 = square(6, 2);
        System.out.println(" p = 6, k = 1, s = " + result2);
    }
}
