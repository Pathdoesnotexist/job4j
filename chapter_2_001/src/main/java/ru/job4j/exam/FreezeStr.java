package ru.job4j.exam;

import java.util.*;

public class FreezeStr {
    public static boolean eq(String left, String right) {
        boolean result = false;
        if (left.length() == right.length()) {
            Map<Character, Integer> leftMap = new HashMap<>();
            Map<Character, Integer> rightMap = new HashMap<>();
            for (int i = 0; i < left.length(); i++) {
                if (leftMap.containsKey(left.charAt(i))) {
                    leftMap.put(left.charAt(i), leftMap.get(left.charAt(i)) + 1);
                } else {
                    leftMap.put(left.charAt(i), 1);
                }
                if (rightMap.containsKey(right.charAt(i))) {
                    rightMap.put(right.charAt(i), rightMap.get(right.charAt(i)) + 1);
                } else {
                    rightMap.put(right.charAt(i), 1);
                }
            }
            result = leftMap.equals(rightMap);
        }
        return result;
    }
}
