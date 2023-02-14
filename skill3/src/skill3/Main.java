package skill3;

import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int c = scan.nextInt();
        int p = scan.nextInt();
        int n = scan.nextInt();

        int[] y = new int[n];
        for (int i = 0; i < n; i++) {
            y[i] = scan.nextInt();
        }

        int[] x = new int[p];
        for (int i = 0; i < p; i++) {
            x[i] = scan.nextInt();
        }

        // Initialize an array to store the value of z for each course
        int[] z = new int[c];
        Arrays.fill(z, Integer.MAX_VALUE);

        // Calculate the value of z for each course
        for (int i = 0; i < n; i++) {
            int course = i + 1;
            int cnt = 1;
            for (int j = i + 1; j < n; j++) {
                if (y[j] == y[i]) {
                    cnt++;
                }
            }
            z[course - 1] = cnt * y[i];
        }

        // Initialize an array to store the courses that Monk and his friends choose
        int[] courses = new int[p];

        // Monk chooses his course first
        int min = Integer.MAX_VALUE;
        int minCourse = -1;
        for (int i = 0; i < c; i++) {
            if (z[i] < min) {
                min = z[i];
                minCourse = i + 1;
            }
        }
        courses[0] = minCourse;
        z[minCourse - 1] = Integer.MAX_VALUE;

        // Monk's friends choose their courses one at a time
        for (int i = 1; i < p; i++) {
            min = Integer.MAX_VALUE;
            minCourse = -1;
            for (int j = 0; j < c; j++) {
                if (z[j] < min) {
                    min = z[j];
                    minCourse = j + 1;
                }
            }
            courses[i] = minCourse;
            z[minCourse - 1] = Integer.MAX_VALUE;
        }

        // Print the courses that Monk and his friends choose
        for (int i = 0; i < p; i++) {
            System.out.print(courses[i] + " ");
        }
    }
}
