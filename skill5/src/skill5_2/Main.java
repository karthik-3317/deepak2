package skill5_2;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int count = 0;
    for (int i = 0; i < n; i++) {
      int num = sc.nextInt();
      if (num >= 1 && num <= n/2) {
        count++;
      }
    }
    System.out.println(Math.min(count, n/2));
  }
}

