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

    // Didn't use std array because of quicksort worst case
    ArrayList<Integer> students = new ArrayList<>();

    for (int i = 0; i < n; i++) {
      students.add(in.nextInt());
    }

    Collections.sort(students);

    // Find the max # students by binary searching for highest idx value <= 5
    int max = 1;
    for (int i = 0; i < n; i++) {
      int potentialMax = checkMax(i, students);
      if (potentialMax > max) {
        max = potentialMax;
      }
    }

    out.println(max);

    out.flush();
  }

  private static int checkMax(int targetIdx, ArrayList<Integer> students) {
    int maxIdx = targetIdx;
    int lo = targetIdx + 1;
    int hi = students.size() - 1;

    while (lo <= hi) {
      int mid = (lo + hi) / 2;

      // Check upper half if current mid works
      if (students.get(mid) - students.get(targetIdx) <= 5) {
        maxIdx = mid;
        lo = mid + 1;
      } else {
        hi = mid - 1;
      }
    }

    // Return length of inclusive range from targetIdx to maxIdx
    return maxIdx - targetIdx + 1;
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
