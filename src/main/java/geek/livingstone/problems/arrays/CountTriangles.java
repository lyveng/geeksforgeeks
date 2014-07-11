package geek.livingstone.problems.arrays;

import java.util.Arrays;

/**
 * Full Problem at http://www.geeksforgeeks.org/find-number-of-triangles-possible/
 * 
 * @author emmanuel
 *
 */
public class CountTriangles {
  public static int count(int[] A) {
    int c = 0;
    if (A.length < 3)
      return 0;
    Arrays.sort(A);
    for (int i = 0; i < A.length; i++) {
      boolean isFirst = true;
      for (int j = i + 1, k = A.length - 1; j < A.length; j++) {
        if (isFirst) {
          while (k > j && A[i] + A[j] <= A[k])
            k--;
          isFirst = false;
        } else {
          while (k < A.length && A[i] + A[j] > A[k])
            k++;
          k--;
        }
        if (k > j && k < A.length)
          c += (k - j);
      }
    }
    return c;
  }

  public static void main(String[] args) {
    System.out.println(count(new int[] {4, 6, 3, 7}));
    System.out.println(count(new int[] {10, 21, 22, 100, 101, 200, 300}));
  }

}
