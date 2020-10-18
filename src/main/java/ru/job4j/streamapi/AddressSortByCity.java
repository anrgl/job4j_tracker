package ru.job4j.streamapi;

import java.util.Comparator;

public class AddressSortByCity implements Comparator<Address> {
    @Override
    public int compare(Address left, Address right) {
        String leftCity = left.getCity();
        String rightCity = right.getCity();
        return leftCity.compareTo(rightCity);
    }
}
