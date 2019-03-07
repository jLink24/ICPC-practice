import java.util.*;
import java.io.*;

// Solution to Codeforces Problem #1133A: Middle of the Contest
// https://codeforces.com/contest/1133/problem/A
// Solution by: jLink23

public class Middle {
  private static PrintWriter out;

  public static void main(String[] args) {
    out = new PrintWriter(System.out);
    FastScanner in = new FastScanner();

    String t1 = in.next();
    String t2 = in.next();

    int h1 = Integer.parseInt(t1.substring(0,2));
    int m1 = Integer.parseInt(t1.substring(3));

    int h2 = Integer.parseInt(t2.substring(0,2));
    int m2 = Integer.parseInt(t2.substring(3));

    m1 += h1 * 60;
    m2 += h2 * 60;

    int avgm = (m1 + m2) / 2;
    int avgh = avgm / 60;
    avgm -= avgh * 60;

    out.println(String.format("%02d:%02d", avgh, avgm));

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
