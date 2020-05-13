package ru.job4j.exam;

import java.util.*;

public class FreezeStr {
    public static boolean eq(String left, String right) {
        boolean result = false;
        if (left.length() == right.length()) {
            char[] leftCharArr = left.toCharArray();
            char[] rightCharArr = right.toCharArray();
            Map<Character, Integer> leftMap = new HashMap<>();
            Map<Character, Integer> rightMap = new HashMap<>();

            for (int i = 0; i < leftCharArr.length; i++) {
                if (leftMap.containsKey(leftCharArr[i])) {
                    leftMap.put(leftCharArr[i], leftMap.get(leftCharArr[i]) + 1);
                } else {
                    leftMap.put(leftCharArr[i], 1);
                }
                if (rightMap.containsKey(rightCharArr[i])) {
                    rightMap.put(rightCharArr[i], rightMap.get(rightCharArr[i]) + 1);
                } else {
                    rightMap.put(rightCharArr[i], 1);
                }
            }
            result = leftMap.equals(rightMap);
        }
        return result;
    }
}
