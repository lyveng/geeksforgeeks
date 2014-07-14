package geek.livingstone.problems.binarysearchtree;

/**
 * Given two arrays which represent a sequence of keys. Imagine we make a Binary Search Tree (BST)
 * from each array. We need to tell whether two BSTs will be identical or not without actually
 * constructing the tree.
 * 
 * Full problem at http://www.geeksforgeeks.org/check-for-identical-bsts-without-building-the-trees/
 * 
 * @author emmanuel
 * 
 */
public class CheckIdenticalBSTWithoutBuildingIt {
  public static boolean isIdentical(int[] a, int[] b) {
    return isIdentical(a, b, 0, 0, Integer.MAX_VALUE, Integer.MIN_VALUE);
  }

  private static boolean isIdentical(int[] a, int[] b, int ai, int bi, int max, int min) {
    int aj, bj;
    for (aj = ai; aj < a.length; aj++)
      if (a[aj] < max && a[aj] > min)
        break;
    for (bj = bi; bj < a.length; bj++)
      if (b[bj] < max && b[bj] > min)
        break;
    if (aj == a.length && bj == b.length)
      return true;
    else if (aj == a.length || bj == b.length)
      return false;
    if (a[aj] != b[bj])
      return false;
    return isIdentical(a, b, aj + 1, bj + 1, a[aj], min) && isIdentical(a, b, aj + 1, bj + 1, max, a[aj]);
  }

  public static void main(String[] args) {
    System.out.println(isIdentical(new int[] {2, 4, 3, 1}, new int[] {2, 1, 4, 3}));
    System.out.println(isIdentical(new int[] {8, 3, 6, 1, 4, 7, 10, 14, 13}, new int[] {8, 10, 14, 3, 6, 4, 1, 7, 13}));
  }

}
