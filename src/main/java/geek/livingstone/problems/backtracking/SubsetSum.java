package geek.livingstone.problems.backtracking;

import java.util.BitSet;

/**
 * Full problem at http://www.geeksforgeeks.org/backttracking-set-4-subset-sum/
 * 
 * @author emmanuel
 * 
 */
public class SubsetSum {
  public static void find(int[] A, int sum) {
    BitSet set = new BitSet(A.length);
    if (!findUtil(A, set, 0, 0, sum))
      System.out.println("No subset found");
  }

  private static boolean findUtil(int[] A, BitSet set, int pos, int curSum, int targetSum) {
    if (curSum == targetSum) {
      printSet(A, set);
      return true;
    } else if (curSum > targetSum || pos >= A.length)
      return false;

    set.set(pos);
    if (findUtil(A, set, pos + 1, curSum + A[pos], targetSum))
      return true;
    set.clear(pos);

    if (findUtil(A, set, pos + 1, curSum, targetSum))
      return true;
    return false;
  }

  private static void printSet(int[] A, BitSet set) {
    for (int i = 0; i < A.length; i++)
      if (set.get(i))
        System.out.print(A[i] + " ");
    System.out.println();
  }

  public static void main(String[] args) {
    find(new int[] {15, 22, 14, 26, 32, 9, 16, 8}, 53);
  }

}
