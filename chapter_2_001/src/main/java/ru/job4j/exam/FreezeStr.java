package ru.job4j.exam;

import java.util.Arrays;

public class FreezeStr {
    public static boolean eq(String left, String right) {
        boolean result = false;
        if (left.length() == right.length()) {
            char[] leftCharArr = left.toCharArray();
            char[] rightCharArr = right.toCharArray();
            Arrays.sort(leftCharArr);
            Arrays.sort(rightCharArr);
            result = Arrays.equals(leftCharArr, rightCharArr);
        }
        return result;
    }
}
