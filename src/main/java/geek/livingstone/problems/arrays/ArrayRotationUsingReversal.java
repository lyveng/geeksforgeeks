package geek.livingstone.problems.arrays;

import java.util.Arrays;

public class ArrayRotationUsingReversal {
  public static void rotate(int[] A, int d) {
    reverse(A, 0, d-1);
    reverse(A, d, A.length-1);
    reverse(A, 0, A.length-1);
  }

  private static void reverse(int[] A, int low, int high) {
    int tmp;
    while (low < high)
    {
      tmp = A[low];
      A[low] = A[high];
      A[high] = tmp;
      low++;
      high--;
    }
  }
  public static void main(String[] args) {
    int[] A = {1, 2, 3, 4, 5, 6};
    System.out.println(Arrays.toString(A));
    rotate(A, 4);
    System.out.println(Arrays.toString(A));
  }

}
