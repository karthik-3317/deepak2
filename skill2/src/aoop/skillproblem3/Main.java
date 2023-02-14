package aoop.skillproblem3;

import java.util.Arrays;
import java.util.List;

class Main {
    public static <T extends Integer> T findRelativelyPrime(List<T> list, List<T> integers) {
        for (T element : list) {
            boolean isRelativelyPrime = true;
            for (T integer : integers) {
                if (gcd(element, integer) != 1) {
                    isRelativelyPrime = false;
                    break;
                }
            }
            if (isRelativelyPrime) {
                return element;
            }
        }
        return null;
    }

    public static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        } else {
            return gcd(b, a % b);
        }
    }

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(3, 4, 6, 8, 11, 15, 28, 32);
        List<Integer> integers = Arrays.asList(7, 18, 19, 25);
        Integer relativelyPrime = findRelativelyPrime(list, integers);
        if (relativelyPrime != null) {
            System.out.println(relativelyPrime + " is relatively prime to " + integers);
        } else {
            System.out.println("No integer in the list is relatively prime to " + integers);
        }
    }
}
