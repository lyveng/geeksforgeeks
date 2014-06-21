package geek.livingstone.problems.arrays;

public class NonAdjacentMaximumSumSubsequence {
  public static int getMaxSubSequenceSum(int[] A) {
    // sum[i] will be the max sum for A[0...i]
    int[] sum = new int[A.length+1];
    int maxSum = Integer.MIN_VALUE;
    for (int i=0;i<A.length;i++)
    {
      sum[i] = A[i];
      for (int j=i-2;j>=0;j--)
        if (A[i] + sum[j] > sum[i])
          sum[i] = A[i] + sum[j];
      if (sum[i] > maxSum)
        maxSum = sum[i];
    }
    return maxSum;
  }

  public static void main(String[] args) {
    System.out.println(getMaxSubSequenceSum(new int[] {3,2,7,10}));
    System.out.println(getMaxSubSequenceSum(new int[] {3,2,5,10,7}));
    System.out.println(getMaxSubSequenceSum(new int[] {5,  5, 10, 40, 50, 35}));
  }

}
