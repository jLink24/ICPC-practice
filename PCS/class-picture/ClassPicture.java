import java.util.*;
import java.io.*;

// Solution to PCS Problem 332: Class Picture
// https://pcs.cs.cloud.vt.edu/problems/332
// Solution by: jLink23

class ClassPicture {
  private static String[][] hate;
  private static PrintWriter out;
  private static String[] kids;

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    out = new PrintWriter(System.out);

    while (in.hasNext()) {
      int class_size = in.nextInt();
      kids = new String[class_size];

      // Populate kids array
      for (int i = 0; i < class_size; i++) {
        kids[i] = in.next();
      }
      // Sort array
      Arrays.sort(kids);

      // Populate hate array
      hate = new String[class_size][class_size];
      int numHate = in.nextInt();
      for (int i = 0; i < numHate; i++) {
        // Get hate pair
        String student1 = in.next();
        String student2 = in.next();

        // Find hate pair respective indices
        int student1_idx = findIndex(student1);
        int student2_idx = findIndex(student2);

        // Store the names of those that dislike each other
        addHate(hate[student1_idx], student2);
        addHate(hate[student2_idx], student1);
      }

      // Create bookkeeping lists
      ArrayList<String> used = new ArrayList<String>();
      ArrayList<String> unused = new ArrayList<String>();
      for (int i = 0; i < kids.length; i++) {
        unused.add(kids[i]);
      }

      // Start backtracking algorithm
      if (!backtrack(0, used, unused)) {
        out.println("You all need therapy.");
      } else {
        // Print valid result
        StringBuilder str = new StringBuilder();
        for (String kid: used) {
          str.append(String.format("%s ", kid));
        }
        str.deleteCharAt(str.length()-1);
        out.println(str);
      }
    }

    in.close();
    out.flush();
  }

  // Method finds an index based on the name given
  public static int findIndex(String str) {
    for (int i = 0; i < kids.length; i++) {
      if (kids[i].equals(str)) return i;
    }
    return -1;
  }

  // Adds name to hate array
  public static void addHate(String[] hate, String name) {
    int count = 0;
    while (count < hate.length) {
      if (hate[count] == null) {
        hate[count] = name;
        return;
      }
      count++;
    }
  }

  public static boolean backtrack(int loc, ArrayList<String> used, ArrayList<String> unused) {
    if (hasInvalidPair(used, loc)) return false;

    if (unused.size() == 0) return true;

    for (int i = 0; i < unused.size(); i++) {
      // Add a kid
      used.add(unused.get(i));
      unused.remove(i);

      if (backtrack(++loc, used, unused)) return true;

      // if its not undo
      unused.add(used.get(used.size()-1));
      Collections.sort(unused); // Need sort for proper ordering
      used.remove(used.size()-1);
      loc--;
    }

    return false;
  }

  public static boolean hasInvalidPair(ArrayList<String> grouping, int loc) {

    if (grouping.size() < 2) {
      return false;
    }

    // Get the index of the past student and see if the current student is hated
    // by them.
    int student_idx = findIndex(grouping.get(loc-2));
    List<String> hates = Arrays.asList(hate[student_idx]);
    if (hates.size() > 0 && hates.contains(grouping.get(loc-1))) {
        return true;
    }

    return false;
  }
}
