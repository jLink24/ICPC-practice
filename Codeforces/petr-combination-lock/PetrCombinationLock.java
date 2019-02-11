import java.util.*;
import java.io.*;

// Solution to Codeforces Problem 1097B: B. Petr and a Combination Lock
// https://codeforces.com/problemset/problem/1097/B
// Solution by: jLink23

public class PetrCombinationLock {
  private static PrintWriter out;

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    out = new PrintWriter(System.out);

    while (in.hasNext()) {
      int N = in.nextInt();

      int[] numbers = new int[N];
      for (int i = 0; i < N; i++) {
        numbers[i] = in.nextInt();
      }

      int[] combination;
      // Generate masks
      for (int mask = 0; mask < (1<<N); mask++) {
        combination = new int[N];
        // Apply mask
        for (int i = 0; i < N; i++) {
          if (getBit(mask, i) == 1) {
            combination[i] = numbers[i];
          } else {
            combination[i] = -1 * numbers[i];
          }
        }
        // Check answers
        int sum = 0;
        for (int i = 0; i < N; i++) {
          sum += combination[i];
        }

        sum %= 360;

        if (sum == 0) {
          out.println("YES");
          in.close();
          out.flush();
          return;
        }
      }

      out.println("NO");
    }

    in.close();
    out.flush();
  }


  public static int getBit(int number, int position)
  {
     return (number >> position) & 1;
  }

}
