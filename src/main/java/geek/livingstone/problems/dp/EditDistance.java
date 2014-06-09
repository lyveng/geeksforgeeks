package geek.livingstone.problems.dp;

import java.util.Arrays;
import java.util.Collections;

/**
 * Full problem at http://www.geeksforgeeks.org/dynamic-programming-set-5-edit-distance/
 * Given two strings of size m, n and set of operations replace (R), insert (I) and delete (D) all at
 * equal cost. Find minimum number of edits (operations) required to convert one string into another.
 * 
 * @author emmanuel
 * 
 */
public class EditDistance {
  public EditDistance(String a, String b) {
    int[][] E = new int[a.length()+1][b.length()+1];
    for (int i=0;i<=a.length();i++)
    {
      for (int j=0;j<=b.length();j++)
      {
        if (i==0) {
          E[i][j] = j;
          continue;
        }
        if (j == 0) {
          E[i][j] = i;
          continue;
        }
        E[i][j] = Collections.min(Arrays.asList(
          new Integer[] {E[i][j-1] + 1, // Align char i of a with char j-1 of b. delete or insert
                         E[i-1][j] + 1, // Align char i-1 of a with char i of b. delete or insert
                         E[i-1][j-1] + (a.charAt(i-1) == b.charAt(j-1) ? 0 : 1)})); // Align char i of a with char j of b. if char i of a != char j of b then replace.
      }
    }
    for (int i=0;i<=a.length();i++)
      System.out.println(Arrays.toString(E[i]));
    System.out.println(String.format("Edit distance of a %s and b %s is %d", a, b, E[a.length()][b.length()]));
  }

  public static void main(String[] args) {
    new EditDistance("SUNDAY", "SATURDAY");
  }

}
