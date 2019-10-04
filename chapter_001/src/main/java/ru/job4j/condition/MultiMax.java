package ru.job4j.condition;

public class MultiMax {
    public int max(int first, int second, int third) {
//        int result = first > second? first:second;
//        result = result > third? result:third;
        int result = Math.max(Math.max(first, second), third);
        return result;
    }
}