package geek.livingstone.problems.backtracking;

/**
 * Full problem at
 * http://www.geeksforgeeks.org/write-a-c-program-to-print-all-permutations-of-a-given-string/
 * 
 * @author emmanuel
 * 
 */
public class Permutations {
  public static void printPermutations(String s) {
    printPermutationsUtil(new StringBuilder(s), 0, s.length() - 1);
  }

  private static void printPermutationsUtil(StringBuilder s, int start, int end) {
    if (start == end)
      System.out.println(s.toString());
    else {
      for (int i = start; i <= end; i++) {
        swap(s, start, i);
        printPermutationsUtil(s, start + 1, end);
        swap(s, start, i);
      }
    }
  }

  private static void swap(StringBuilder s, int i, int j) {
    char tmp = s.charAt(i);
    s.setCharAt(i, s.charAt(j));
    s.setCharAt(j, tmp);
  }

  public static void main(String[] args) {
    printPermutations("ABC");
  }

}
