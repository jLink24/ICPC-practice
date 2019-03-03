import java.util.*;
import java.io.*;

// Solution to Codeforces Problem 1097A: Gennady and a Card Game
// https://codeforces.com/problemset/problem/1097/A
// Solution by: jLink23

public class Gennady {
  private static PrintWriter out;

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    out = new PrintWriter(System.out);

    String table = in.next();
    boolean canPlay = false;

    while (in.hasNext()) {
      String card = in.next();
      if (table.charAt(0) == card.charAt(0) ||
          table.charAt(1) == card.charAt(1)) {
        canPlay = true;
        break;
      }
    }
    if (canPlay) {
      out.println("YES");
    } else {
      out.println("NO");
    }

    in.close();
    out.flush();
  }

}
