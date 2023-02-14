package skill5;

import java.io.*;
import java.util.*;

public class Main {
    static int N = 500005;
    static int[] bit = new int[N];
    static int[] a = new int[N];
    static int mod = 1000000007;
    static int n, q;

    static void add(int x, int val) {
        for (int i = x; i <= n; i += (i & -i)) {
            bit[i] += val;
            bit[i] %= mod;
        }
    }

    static int sum(int x) {
        int ans = 0;
        for (int i = x; i > 0; i -= (i & -i)) {
            ans += bit[i];
            ans %= mod;
        }
        return ans;
    }

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        q = sc.nextInt();
        for (int i = 1; i <= n; i++) {
            a[i] = sc.nextInt();
        }
        Arrays.sort(a, 1, n + 1);
        for (int i = 1; i <= n; i++) {
            add(i, 1);
        }
        while (q-- > 0) {
            char c = sc.next().charAt(0);
            int m = sc.nextInt();
            int pos = Arrays.binarySearch(a, 1, n + 1, m);
            if (c == '<') {
                if (pos < 0) {
                    pos = -pos - 1;
                }
                System.out.println(sum(pos - 1));
            } else if (c == '>') {
                if (pos < 0) {
                    pos = -pos - 2;
                }
                System.out.println((sum(n) - sum(pos) + mod) % mod);
            } else {
                if (pos < 0) {
                    System.out.println("0");
                } else {
                    System.out.println(sum(pos) - sum(pos - 1));
                }
            }
        }
    }
}
