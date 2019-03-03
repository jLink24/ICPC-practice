import java.util.*;
import java.io.*;

// Solution to Codeforces Problem 791A: Bear and Big Brother
// https://codeforces.com/problemset/problem/791/A
// Solution by: jLink23

public class BearAndBigBrother {
  private static PrintWriter out;

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    out = new PrintWriter(System.out);
    int years = 0;
    int a = in.nextInt();
    int b = in.nextInt();

    while (a <= b) {
      a *= 3;
      b *= 2;

      years++;
    }

    out.println(years);

    in.close();
    out.flush();
  }

}
