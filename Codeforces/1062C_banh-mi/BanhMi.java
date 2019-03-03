import java.util.*;
import java.io.*;
import java.math.*;

// Solution to Codeforces Problem 1062: Banh Mi
// https://codeforces.com/problemset/problem/1062/C
// Solution by: jLink23

public class BanhMi {
  private static PrintWriter out;
  public static final int MOD = 1000000007;

  public static void main(String[] args) {
    out = new PrintWriter(System.out);
    FastScanner in = new FastScanner();

    int n = in.nextInt();
    int q = in.nextInt();
    String banhmi = in.next();

    // Create prefix sum array
    int[] prefix = new int[n + 1];
    for (int i = 1; i <= n; i++) {
      if (banhmi.charAt(i-1) == '0') {
        prefix[i] = prefix[i-1];
      } else {
        prefix[i] = prefix[i-1] + 1;
      }
    }

    // Precompute powers of 2 for quicker access
    Long[] pow2 = new Long[100001];
    pow2[0] = 1L;
    for (int i = 1; i <= 100000; i++) {
      pow2[i] = pow2[i-1] * 2L % MOD;
    }

    for (int i = 0; i < q; i++) {
      int l = in.nextInt();
      int r = in.nextInt();

      int k = r-l+1; // Length of segment
      int x = prefix[r] - prefix[l-1]; // Number of 1's
      int y = k - x; // Number of 0's

      out.println(((pow2[x] - 1) * pow2[y]) % MOD);
    }

    out.flush();
  }

  public static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        public FastScanner(Reader in) {
            br = new BufferedReader(in);
        }

        public FastScanner() {
            this(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String readNextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }

        int[] readIntArray(int n) {
            int[] a = new int[n];
            for (int idx = 0; idx < n; idx++) {
                a[idx] = nextInt();
            }
            return a;
        }
    }

}
