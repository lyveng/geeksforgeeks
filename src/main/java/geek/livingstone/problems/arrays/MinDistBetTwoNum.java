package geek.livingstone.problems.arrays;

/**
 * Full problem at http://www.geeksforgeeks.org/find-the-minimum-distance-between-two-numbers/
 * 
 * @author emmanuel
 * 
 */
public class MinDistBetTwoNum {
  public static int findMinDist(int[] A, int x, int y) {
    // xLeftMin[i] contains the minimum dist of x from A[i] on the left side;
    // xRightMin[i] contains the minimum dist of x from A[i] on the right side;
    // xMin[i] contains the minimum dist of x from A[i]
    int[] xLeftMin = new int[A.length], xRightMin = new int[A.length], xMin = new int[A.length];
    int xIndex = -1;
    for (int i = 0; i < A.length; i++) {
      if (A[i] == x) {
        xIndex = i;
        xLeftMin[i] = 0;
      } else if (xIndex == -1)
        xLeftMin[i] = Integer.MAX_VALUE;
      else
        xLeftMin[i] = i - xIndex;
    }
    xIndex = -1;
    for (int i = A.length - 1; i >= 0; i--) {
      if (A[i] == x) {
        xIndex = i;
        xRightMin[i] = 0;
      } else if (xIndex == -1)
        xRightMin[i] = Integer.MAX_VALUE;
      else
        xRightMin[i] = xIndex - i;
    }
    for (int i = 0; i < A.length; i++) {
      xMin[i] = Math.min(xLeftMin[i], xRightMin[i]);
    }

    int minDist = Integer.MAX_VALUE;
    for (int i = 0; i < A.length; i++) {
      if (A[i] == y && minDist > xMin[i]) {
        minDist = xMin[i];
      }
    }
    return minDist;
  }

  public static int findMinDistSimple(int[] A, int x, int y) {
    int cur = -1, min = Integer.MAX_VALUE;
    for (int i = 0; i < A.length; i++) {
      if (A[i] == x || A[i] == y) {
        if (cur != -1 && A[cur] != A[i]) {
          if (i - cur < min)
            min = i - cur;
        }
        cur = i;
      }
    }
    return min;
  }

  public static void main(String[] args) {
    System.out.println(findMinDist(new int[] {1, 2}, 1, 2));
    System.out.println(findMinDist(new int[] {3, 4, 5}, 3, 5));
    System.out.println(findMinDist(new int[] {3, 5, 4, 2, 6, 5, 6, 6, 5, 4, 8, 3}, 3, 6));
    System.out.println(findMinDist(new int[] {2, 5, 3, 5, 4, 4, 2, 3}, 3, 2));
    System.out.println(findMinDistSimple(new int[] {1, 2}, 1, 2));
    System.out.println(findMinDistSimple(new int[] {3, 4, 5}, 3, 5));
    System.out.println(findMinDistSimple(new int[] {3, 5, 4, 2, 6, 5, 6, 6, 5, 4, 8, 3}, 3, 6));
    System.out.println(findMinDistSimple(new int[] {2, 5, 3, 5, 4, 4, 2, 3}, 3, 2));
  }

}
