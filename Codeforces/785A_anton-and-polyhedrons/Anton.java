import java.util.*;
import java.io.*;

// Solution to Codeforces Problem 785A: Anton and Polyhedrons
// https://codeforces.com/problemset/problem/785/A
// Solution by: jLink23

public class Anton {
  private static PrintWriter out;

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    out = new PrintWriter(System.out);

    int n = in.nextInt();

    int total = 0;
    for (int i = 0; i < n; i++) {
      switch (in.next()) {
        case "Tetrahedron":
          total += 4;
          break;
        case "Cube":
          total += 6;
          break;
        case "Octahedron":
          total += 8;
          break;
        case "Dodecahedron":
          total += 12;
          break;
        case "Icosahedron":
          total += 20;
      }
    }

    out.println(total);

    in.close();
    out.flush();
  }

}
