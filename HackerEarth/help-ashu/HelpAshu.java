import java.util.*;
import java.io.*;

// Solution to HackerEarth Problem: Help Ashu
// https://bit.ly/2II9UWO
// Solution by: jLink23

public class HelpAshu {
  private static PrintWriter out;

  public static void main(String[] args) {
    out = new PrintWriter(System.out);
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    try {
      String line = br.readLine();
      StringTokenizer st = new StringTokenizer(line);

      int N = Integer.parseInt(st.nextToken());
      int[] arr = new int[N];

      line = br.readLine();
      st = new StringTokenizer(line);

      // Populate data array
      for (int i = 0; i < N; i++) {
        arr[i] = Integer.parseInt(st.nextToken());
      }

      // Create even and odd BITs
      BIT even = new BIT(N+1);
      BIT odd = new BIT(N+1);

      // O(nlogn) construction
      for (int i = 0; i < N; i++) {
        if (arr[i] % 2 == 0) {
          even.update(i+1, 1);
        } else {
          odd.update(i+1, 1);
        }
      }

      line = br.readLine();
      st = new StringTokenizer(line);

      int Q = Integer.parseInt(st.nextToken());
      for (int i = 0; i < Q; i++) {
        line = br.readLine();
        st = new StringTokenizer(line);
        int q = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        if (q == 0) {
          if (arr[x-1] % 2 == 0 && y % 2 == 1) {
            even.update(x,-1);
            odd.update(x,1);
          } else if (arr[x-1] % 2 == 1 && y % 2 == 0) {
            odd.update(x,-1);
            even.update(x,1);
          }
          arr[x-1] = y;
        } else if (q == 1) {
          out.println(even.rangeSum(x,y));
        } else {
          out.println(odd.rangeSum(x,y));
        }
      }

    } catch (Exception e) {
      e.printStackTrace();
    }

    out.flush();
  }

  private static class BIT {
    private int size;
    private long[] arr;

    public BIT (int sz) {
      size = sz;
      arr = new long[sz];
    }

    public void update(int loc, int amt) {
      while (loc < size) {
        arr[loc] += amt;
        loc += Integer.lowestOneBit(loc);
      }
    }

    public long prefix(int loc) {
      long result = 0L;
      while (loc > 0) {
        result += arr[loc];
        loc -= Integer.lowestOneBit(loc);
      }
      return result;
    }

    public long rangeSum(int l, int r) {
      return prefix(r) - prefix(l-1);
    }

    public String toString() {
      return Arrays.toString(arr);
    }
  }

}
