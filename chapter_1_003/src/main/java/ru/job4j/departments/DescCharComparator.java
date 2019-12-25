package ru.job4j.departments;

import java.util.Comparator;

public class DescCharComparator implements Comparator<String>  {
    @Override
    public int compare(String left, String right) {
        int result = 0;
        int index = 0;
        while (index < left.length() && index < right.length()) {
            result = Character.compare(right.charAt(index), left.charAt(index));
            if (result != 0) {
                break;
            } else {
                index++;
            }
        }
        if (result == 0) {
            result = left.length() - right.length();
        }
        return result;
    }
}
