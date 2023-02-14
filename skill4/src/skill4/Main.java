package skill4;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Main {
    public static int[] sortByBits(int[] arr) {
        Map<Integer, Integer> bitCounts = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            int bitCount = Integer.bitCount(arr[i]);
            if (!bitCounts.containsKey(bitCount)) {
                bitCounts.put(bitCount, i);
            } else {
                int currentIndex = bitCounts.get(bitCount);
                arr[currentIndex] = Math.min(arr[currentIndex], arr[i]);
                bitCounts.put(bitCount, currentIndex + 1);
            }
        }
        Arrays.sort(arr);
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = {0, 1, 2, 3, 4, 5, 6, 7, 8};
        int[] sortedArr = sortByBits(arr);
        System.out.println(Arrays.toString(sortedArr));
    }
}

