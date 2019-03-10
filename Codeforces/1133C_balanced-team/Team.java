import java.util.*;
import java.io.*;

// Solution to Codeforces Problem #1133C: Balanced team
// https://codeforces.com/contest/1133/problem/C
// Solution by: jLink23

public class Team {
  private static PrintWriter out;

  public static void main(String[] args) {
    out = new PrintWriter(System.out);
    FastScanner in = new FastScanner();

    int n = in.nextInt();

    int[] students = new int[n];

    for (int i = 0; i < n; i++) {
      students[i] = in.nextInt();
    }

    Arrays.sort(students);

    int max = 1;
    int count = 1;
    int lowestTeammateIdx = 0;

    for (int i = 1; i < students.length; i++) {
      if (students[i] - students[lowestTeammateIdx] <= 5) {
        count++;
      } else {
        if (count > max) {
          max = count;
        }
        lowestTeammateIdx = i;
        count = 1;
      }
    }

    if (count > max) {
      max = count;
    }

    out.println(max);

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
