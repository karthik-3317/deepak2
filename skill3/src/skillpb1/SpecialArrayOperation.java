package skillpb1;

import java.util.*;

public class SpecialArrayOperation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] A = new int[n];
        for (int i = 0; i < n; i++) {
            A[i] = sc.nextInt();
        }
        Arrays.sort(A);
        int q = sc.nextInt();
        while (q-- > 0) {
            int k = sc.nextInt();
            int sum = 0;
            for (int i = k; i < n - k; i++) {
                sum += A[i];
            }
            System.out.println(sum);
        }
    }
}
