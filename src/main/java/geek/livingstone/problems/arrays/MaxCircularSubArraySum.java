package geek.livingstone.problems.arrays;

/**
 * Full problem at http://www.geeksforgeeks.org/maximum-contiguous-circular-sum/
 * 
 * @author emmanuel
 * 
 */
public class MaxCircularSubArraySum {
  public static int maxCircularSum(int[] A) {
    int totalSum = 0;
    for (int i = 0; i < A.length; i++) {
      totalSum += A[i];
    }
    int nonWrappedMaxSum = maxSum(A);
    invertSign(A);
    int wrappedMaxSum = totalSum + maxSum(A);
    return Math.max(nonWrappedMaxSum, wrappedMaxSum);
  }

  private static void invertSign(int[] A) {
    for (int i = 0; i < A.length; i++) {
      A[i] = -A[i];
    }
  }

  private static int maxSum(int[] A) {
    int maxSumSoFar = Integer.MIN_VALUE, maxSumEndingHere = 0;
    for (int i = 0; i < A.length; i++) {
      maxSumEndingHere += A[i];
      if (maxSumEndingHere < 0)
        maxSumEndingHere = 0;
      if (maxSumEndingHere > maxSumSoFar)
        maxSumSoFar = maxSumEndingHere;
    }
    return maxSumSoFar;
  }

  public static void main(String[] args) {
    System.out.println(maxCircularSum(new int[] {8, -8, 9, -9, 10, -11, 12}));
    System.out.println(maxCircularSum(new int[] {10, -3, -4, 7, 6, 5, -4, -1}));
    System.out.println(maxCircularSum(new int[] {-1, 40, -14, 7, 6, 5, -4, -1}));
  }

}
