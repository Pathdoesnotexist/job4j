package ru.job4j.сomparisons;

import java.util.Comparator;

public class ListCompare implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        int result = 0;
        int shortCircle = left.length();
        int longerString = left.length() - right.length();

         if (left.length() > right.length()) {
            shortCircle = right.length();
             longerString = right.length() - left.length();
        }

        for (int i = 0; i < shortCircle; i++) {
            result = Character.compare(left.charAt(i), right.charAt(i));
            if (result != 0) {
                break;
            }
        }
        if (result == 0 && left.length() != right.length()) {
            result = longerString;
        }
        return result;
    }
}

