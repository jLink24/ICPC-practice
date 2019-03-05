import java.util.*;
import java.io.*;

// Solution to Codeforces Problem 1077D: Cutting Out
// https://codeforces.com/contest/1077/problem/D
// Solution by: jLink23

public class CuttingOut {
  private static PrintWriter out;

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    out = new PrintWriter(System.out);

    int n = in.nextInt();
    int k = in.nextInt();

    int[] s = new int[n];

    for (int i = 0; i < n; i++) {
      s[i] = in.nextInt();
    }

    int lo = 0;
    int hi = n/k;
    int[] max = null; // Holds the max array that can be removed
    int[] t = null;

    while (lo <= hi) {
      int mid = (lo + hi) / 2;

      t = check(mid, k, s);

      if (t != null) {
        max = t;
        lo = mid + 1;
      } else {
        hi = mid - 1;
      }
    }

    if (max != null) {
      for (int i = 0; i < max.length; i++) {
        out.print(max[i] + " ");
      }
      out.println();
    }

    in.close();
    out.flush();
  }

  private static int[] check(int size, int k, int[] s) {
    int count = 0;
    int tIdx = 0;

    HashMap<Integer, Integer> map = new HashMap<>();
    int[] t = new int[k];

    for (int i = 0; i < s.length; i++) {
      if (map.containsKey(s[i])) {
        map.put(s[i], map.get(s[i]) + 1);
      } else {
        map.put(s[i], 1);
      }

      if (map.get(s[i]) >= size) {
        t[tIdx] = s[i];
        map.put(s[i], 0);
        tIdx++;
        count++;
      }

      if (count == k) {
        break;
      }
    }

    return (tIdx == k) ? t : null;
  }

}
