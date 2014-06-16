package geek.livingstone.problems.binarysearchtree;

/**
 * Find total number of possible binary search trees with n keys.
 * 
 * Full problem at http://www.geeksforgeeks.org/g-fact-18/
 * 
 * @author emmanuel
 * 
 */
public class PossibleBSTsWithNKeys {
  public static int possibleBstCount(int n) {
    assert n > 0;
    int[] count = new int[n + 1];
    count[0] = 1; // empty bst
    count[1] = 1;
    count[2] = 2;
    for (int i = 3; i <= n; i++) {
      count[i] = 0;
      for (int j = 0; j < i; j++) {
        count[i] += (count[j] * count[i - j - 1]);
      }
    }
    return count[n];
  }

  public static void main(String[] args) {
    System.out.println(possibleBstCount(3));
    System.out.println(possibleBstCount(4));
    System.out.println(possibleBstCount(5));
  }

}
