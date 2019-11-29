package ru.job4j.stream;

import java.util.Comparator;

public class AddressComparator implements Comparator<Address> {
    @Override
    public int compare(Address left, Address right) {
        String leftCity = left.getCity();
        String rightCity = right.getCity();
        int result = 0;
        int index = 0;

        while (index < leftCity.length() && index < rightCity.length()) {
            result = Character.compare(leftCity.charAt(index), rightCity.charAt(index));
            if (result != 0) {
                break;
            } else {
                index++;
            }
        }
        if (result == 0) {
            result = leftCity.length() - rightCity.length();
        }
        return result;
    }
}
