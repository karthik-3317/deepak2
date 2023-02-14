package com.aoop.skill2;

import java.util.Arrays;
import java.util.Collection;

class Main {
    public static <T> int countByProperty(Collection<T> collection, PropertyChecker<T> checker) {
        int count = 0;
        for (T element : collection) {
            if (checker.check(element)) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Collection<Integer> collection = Arrays.asList(1, 2, 3, 4, 11, 17);
        int oddCount = countByProperty(collection, new OddChecker());
        System.out.println("Number of odd integers = " + oddCount);
    }
}
