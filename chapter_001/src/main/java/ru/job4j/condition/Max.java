package ru.job4j.condition;

public class Max {


    public static int maximum(int first, int second) {
        return Math.max(first, second);
    }

    public static int maximum(int first, int second, int three) {
        return maximum(maximum(first, second), three);
    }

}

