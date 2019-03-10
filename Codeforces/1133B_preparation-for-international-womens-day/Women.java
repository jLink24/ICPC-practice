import java.util.*;
import java.io.*;

// Solution to Codeforces Problem 1133B: Preparation for International Women's Day
// https://codeforces.com/contest/1133/problem/B
// Solution by: jLink23

public class Women {
  private static PrintWriter out;

  public static void main(String[] args) {
    out = new PrintWriter(System.out);
    FastScanner in = new FastScanner();

    int n = in.nextInt();
    int k = in.nextInt();

    int[] leftovers = new int[k];

    // Keep track of leftovers (the amount of candies mod k from each box)
    for (int i = 0; i < n; i++) {
      leftovers[in.nextInt() % k]++;
    }

    // Boxes with mod 0 can be given directly to the girls w/o combining
    int ans = leftovers[0] / 2;

    // Even k means you can combine two boxes with k/2 remainder to make 1 gift
    if (k % 2 == 0) {
      ans += leftovers[k/2] / 2;
    }

    // Add up boxes with mod i and mod k-i to create boxes with 0 remainder
    for (int i = 1; i < (k+1)/2; i++) {
      // Don't need to divide by two because you are combining 2 boxes
      ans += Math.min(leftovers[i], leftovers[k-i]);
    }

    // Multiply by two because question asks about # of boxes not gifts
    out.println(ans * 2);


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
