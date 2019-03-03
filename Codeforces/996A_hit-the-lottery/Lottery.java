import java.util.*;
import java.io.*;

// Solution to Codeforces Problem 996A: Hit the lottery
// https://codeforces.com/problemset/problem/996/A
// Solution by: jLink23

public class Lottery {
  private static PrintWriter out;

  public static void main(String[] args) {
    out = new PrintWriter(System.out);
    FastScanner in = new FastScanner();

    int n = in.nextInt();

    int count = 0;
    count += n / 100;
    n -= (n / 100) * 100;

    count += n / 20;
    n -= (n / 20) * 20;

    count += n / 10;
    n -= (n / 10) * 10;

    count += n / 5;
    n -= (n / 5) * 5;

    count += n / 1;

    out.println(count);

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
