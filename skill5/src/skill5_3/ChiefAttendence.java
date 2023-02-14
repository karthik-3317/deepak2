package skill5_3;

import java.util.HashMap;
import java.util.Scanner;

public class ChiefAttendence {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    while (t-- > 0) {
      int n = sc.nextInt();
      HashMap<String, Integer> firstNames = new HashMap<>();
      for (int i = 0; i < n; i++) {
        String firstName = sc.next();
        String lastName = sc.next();
        int count = firstNames.getOrDefault(firstName, 0);
        firstNames.put(firstName, count + 1);
        if (count == 0) {
          System.out.println(firstName);
        } else {
          System.out.println(firstName + " " + lastName);
        }
      }
    }
    sc.close();
  }
}

