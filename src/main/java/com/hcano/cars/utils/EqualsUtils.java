package com.hcano.cars.utils;

public class EqualsUtils {
    private EqualsUtils() { }

    public static boolean isEquals(Object o1, Object o2) {
        if(o1 == null && o2 != null || o1 != null && o2 == null) {
            return false;
        }

        if (o1 == o2) return true;
        if (o1.getClass() != o2.getClass()) return false;

        return o1.hashCode() == o2.hashCode();
    }
}
