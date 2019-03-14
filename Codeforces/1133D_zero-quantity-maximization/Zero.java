import java.util.*;
import java.io.*;

// Solution to Codeforces Problem #1133D: Zero quantity maximization
// https://codeforces.com/contest/1133/problem/D
// Solution by: jLink23

public class Zero {
  private static PrintWriter out;

  public static void main(String[] args) {
    out = new PrintWriter(System.out);
    FastScanner in = new FastScanner();

    int n = in.nextInt();
    int[] a = new int[n];
    int[] b = new int[n];

    for (int i = 0; i < n; i++) {
      a[i] = in.nextInt();
    }

    for (int i = 0; i < n; i++) {
      b[i] = in.nextInt();
    }

    HashMap<Fraction, Integer> map = new HashMap<>();
    int nZeroProducts = 0; // When a[i] and b[i] == 0, any d works
    int max = 0;
    for (int i = 0; i < n; i++) {
      if (a[i] == 0) {
        if (b[i] == 0) nZeroProducts++;
      } else {
        // Using d = -b/a, keep a running count of the # of times each d occurs
        // The optimal d will occur the most times
        Fraction d = new Fraction(-b[i], a[i]);
        if (map.containsKey(d)) {
          map.put(d, map.get(d) + 1);
        } else {
          map.put(d, 1);
        }

        if (map.get(d) > max) {
          max = map.get(d);
        }
      }
    }

    // Don't forget to add pairs where a and b == 0 because they work with all
    out.println(max + nZeroProducts);

    out.flush();
  }

  // Use custom fraction class to prevent rounding errors
  public static class Fraction {
    int num;
    int den;

    public Fraction(int num, int den) {
      this.num = num;
      this.den = den;
      this.norm();
    }

    // Used to reduce fraction and keep in proper form
    public void norm() {
      if(den < 0) {
    		num *= -1;
    		den *= -1;
	    }
      int gcd = gcd(num, den);
      this.num /= gcd;
      this.den /= gcd;
      if (num == 0) {
        den = 0;
      }
    }

    // Euclidean gcd algorithm
    // Idea is that if you keep taking from the biggest the gcd stays the same
    public int gcd(int a, int b)
    {
      if (b == 0)
        return a;
      return gcd(b, a % b);
    }

    // Had to implement equals and hashcode for using fraction in hashmap
    @Override
    public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null) return false;
      if (!(o instanceof Fraction)) return false;

      Fraction f = (Fraction)o;

      return Objects.equals(this.num, f.num) && Objects.equals(this.den, f.den);
    }

    @Override
    public int hashCode() {
      return Objects.hash(num, den);
    }

    @Override
    public String toString() {
      return num + "/" + den;
    }
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
