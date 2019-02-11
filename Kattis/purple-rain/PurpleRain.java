import java.util.*;
import java.io.*;

// Solution to Kattis Problem: Purple Rain
// https://open.kattis.com/problems/purplerain
// Solution by: jLink23

public class PurpleRain {
  private static PrintWriter out;

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    out = new PrintWriter(System.out);

    String rain = in.nextLine();

    // Create rain prefix sum array
    int[] prefix = new int[rain.length() + 1];
    prefix[0] = 0;

    for (int i = 1; i < prefix.length; i++) {
      if (rain.charAt(i-1) == 'B') {
        prefix[i] = prefix[i-1] + 1;
      } else {
        prefix[i] = prefix[i-1] - 1;
      }
    }

    // Find max
    int max = 0;
    for (int i = 1; i < prefix.length; i++) {
      if (prefix[max] < prefix[i]) {
        max = i;
      }
    }

    // Find min
    int min = 0;
    for (int i = 1; i < prefix.length; i++) {
      if (prefix[min] > prefix[i]) {
        min = i;
      }
    }

    if (min > max) {
      out.println(String.format("%d %d", max + 1, min));
    } else {
      out.println(String.format("%d %d", min + 1, max));
    }

    in.close();
    out.flush();
  }

}
