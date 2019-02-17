import java.util.*;
import java.io.*;

// Solution to Kattis Problem: Fenwick Tree
// https://open.kattis.com/problems/fenwick
// Solution by: jLink23

public class FenwickTree {
  private static PrintWriter out;

  public static void main(String[] args) {
    out = new PrintWriter(System.out);
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    try {
      String line = br.readLine();
      StringTokenizer st = new StringTokenizer(line);

      int N = Integer.parseInt(st.nextToken());
      int Q = Integer.parseInt(st.nextToken());

      BIT bit = new BIT(N+1);

      for (int i = 0; i < Q; i++) {
        line = br.readLine();
        st = new StringTokenizer(line);
        String operation = st.nextToken();
        if (operation.equals("+")) {
          bit.update(Integer.parseInt(st.nextToken()) + 1,
          Integer.parseInt(st.nextToken()));
        } else {
          int n = Integer.parseInt(st.nextToken());
          if (n == 0) {
            out.println(0);
          } else {
            out.println(bit.prefixSum(n));
          }
        }
      }
    } catch (Exception e) {
      e.printStackTrace();
    }

    out.flush();
  }

  private static class BIT {
      int size;
      long[] table;
      public BIT (int ss) {
          size = ss;
          table = new long[ss];
      }

      public void update(int loc, long amt) {
        while(loc < size) {
            table[loc] += amt;
            loc += Integer.lowestOneBit(loc); //loc & -loc
        }
      }

      public long prefixSum(int loc) {
        long ret = 0L;
        while(loc > 0) {
            ret += table[loc];
            loc -= Integer.lowestOneBit(loc); //loc & -loc
        }
        return ret;
      }

      public long rangeSum(int l, int r) {
        return prefixSum(r) - prefixSum(l-1);
      }


  }

}
