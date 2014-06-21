package geek.livingstone.problems.arrays;

import java.util.Arrays;

public class ArrayRotationUsingGCD {
  public static void rotate(int[] A, int d) {
    int blockSize = gcd(A.length, d), tmp, j, k;
    System.out.println("Rotating by block size " + blockSize + " to attain a final rotation by " + d + " positions.");
    for (int i = 0; i < blockSize; i++) {
      tmp = A[i];
      j = i;
      k = (j + d) % A.length;
      while (k != i) {
        A[j] = A[k];
        j = k;
        k = (k + d) % A.length;
      }
      A[j] = tmp;
    }
  }

  private static int gcd(int a, int b) {
    if (a < b) return gcd(b, a);
    if (b == 0)
      return a;
    else
      return gcd(b, a % b);
  }

  public static void main(String[] args) {
    int[] A = {1, 2, 3, 4, 5, 6};
    System.out.println(Arrays.toString(A));
    rotate(A, 2);
    System.out.println(Arrays.toString(A));
  }

}
