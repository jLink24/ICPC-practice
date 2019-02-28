import java.util.*;
import java.io.*;

// Solution to Codeforces Problem 1118B: Tanya And Candies
// https://codeforces.com/problemset/problem/1118/B
// Solution by: jLink23

public class TanyaAndCandies {
  private static PrintWriter out;

  public static void main(String[] args) {
    out = new PrintWriter(System.out);
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    try {
      String line = br.readLine();
      StringTokenizer st = new StringTokenizer(line);

      int N = Integer.parseInt(st.nextToken());

      line = br.readLine();
      st = new StringTokenizer(line);

      // Initialize candy weight array
      int[] candies = new int[N];
      for (int i = 0; i < N; i++) {
        candies[i] = Integer.parseInt(st.nextToken());
      }

      // Initialize separate even/odd prefix arrays
      int[] even = new int[N+1];
      int[] odd = new int[N+1];

      for (int i = 1; i <= N; i++) {
        if (i % 2 == 0) {
          even[i] = even[i-1] + candies[i-1];
        } else {
          even[i] = even[i-1];
        }

        if (i % 2 == 1) {
          odd[i] = odd[i-1] + candies[i-1];
        } else {
          odd[i] = odd[i-1];
        }
      }

      // Test giving each candy to dad
      int result = 0;
      for (int i = 0; i < N; i++) {
        int evenSum = 0;
        int oddSum = 0;
        if (i==0) {
          evenSum = odd[N] - odd[1];
          oddSum = even[N];
        } else if (i > 0 && i < N-1) {
          evenSum = even[i] + odd[N] - odd[i+1];
          oddSum = odd[i] + even[N] - even[i+1];
        } else {
          evenSum = even[N-1];
          oddSum = odd[N-1];
        }

        if (oddSum == evenSum) result++;
      }

      out.println(result);

    } catch (Exception e) {
      e.printStackTrace();
    }

    out.flush();
  }

}
