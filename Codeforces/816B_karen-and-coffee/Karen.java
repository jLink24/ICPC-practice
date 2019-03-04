import java.util.*;
import java.io.*;

// Solution to codeforces Problem #816B: Karen and coffee
// https://codeforces.com/contest/816/problem/B
// Solution by: jLink23

public class Karen {
  private static PrintWriter out;

  public static void main(String[] args) {
    out = new PrintWriter(System.out);
    FastScanner in = new FastScanner();

    int n = in.nextInt(); // Number of recipes
    int k = in.nextInt(); // Min acceptable
    int q = in.nextInt(); // Number of questions

    // Create prefix array temperature array
    int[] c = new int[200001];

    // Increment index l and decrement index r+1
    for (int i = 0; i < n; i++) {
      int l = in.nextInt();
      int r = in.nextInt();
      c[l]++;
      if (r < 200000) {
        c[r+1]--;
      }
    }

    // Calculate prefix array
    int[] prefix = new int[200001];
    for (int i = 1; i < 200001; i++) {
      prefix[i] = prefix[i-1] + c[i];
    }

    // Check if index >= k and set to 1 if it does, 0 otherwise
    for (int i = 1; i < 200001; i++) {
      if (prefix[i] >= k) {
        prefix[i] = 1;
      } else {
        prefix[i] = 0;
      }
    }

    // Recalculate prefix array
    for (int i = 1; i < 200001; i++) {
      prefix[i] = prefix[i-1] + prefix[i];
    }

    // Answer questions using range sums
    for (int i = 0; i < q; i++) {
      int l = in.nextInt();
      int r = in.nextInt();

      out.println(prefix[r] - prefix[l-1]);
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
