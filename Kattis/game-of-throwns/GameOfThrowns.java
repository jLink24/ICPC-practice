import java.util.*;
import java.io.*;

// Solution to Kattis Problem: Game of Throwns
// https://open.kattis.com/problems/throwns
// Solution by: jLink23

public class GameOfThrowns {
  private static PrintWriter out;

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    out = new PrintWriter(System.out);

    int num_students = in.nextInt();
    int num_throws = in.nextInt();

    ArrayDeque<Integer> deq = new ArrayDeque<>();

    for (int i = 0; i < num_throws; i++) {
      String cur_throw = in.next();
      if (cur_throw.equals("undo")) {
        int num_undos = in.nextInt();
        for (int j = 0; j < num_undos; j++) {
          deq.pop();
        }
      } else {
        int throw_pos = Integer.parseInt(cur_throw);
        deq.push(throw_pos);
      }
    }

    // Play out throws without undos
    int final_pos = 0;
    for (Integer n : deq) {
      final_pos += (n % num_students);
      if (final_pos < 0) {
        final_pos += num_students;
      }
      if (final_pos > num_students) {
        final_pos %= num_students;
      }
    }

    out.println(final_pos);

    in.close();
    out.flush();
  }

}
