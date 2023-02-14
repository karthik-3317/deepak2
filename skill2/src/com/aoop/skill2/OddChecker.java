package com.aoop.skill2;

public class OddChecker implements PropertyChecker<Integer> {
    public boolean check(Integer element) {
        return element % 2 != 0;
    }
}
