import java.util.*;
import java.io.*;

// Solution to Codeforces Problem 705A: Hulk
// https://codeforces.com/problemset/problem/705/A
// Solution by: jLink23

public class Hulk {
  private static PrintWriter out;

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    out = new PrintWriter(System.out);

    int n = in.nextInt();

    StringBuilder str = new StringBuilder();
    str.append("I hate");

    for (int i = 1; i < n; i++) {
      if (i % 2 == 1) {
        str.append(" that I love");
      } else {
        str.append(" that I hate");
      }
    }

    str.append(" it");

    out.println(str);

    in.close();
    out.flush();
  }

}
