package geek.livingstone.problems.dp;

import java.util.Arrays;

public class LongestIncreasingSubsequence<T extends Comparable<T>> {
  private T[] lis;

  /**
   * Calculates the longest increasing subsequence and stores it in lis.
   * 
   * LIS[i] is the length of the longest increasing subsequence which ends with input[i].
   * LIS[i] = 1 + max(LIS[j]) where j < i and input[j] < input[i]
   * The problem is a dynamic programming problem with the above optimal substructure and 
   * it is solved using Tabulation(bottom up).
   * 
   * @param input
   */
  public LongestIncreasingSubsequence(T[] input) {
    // length of the longest increasing subsequence that ends with element at index i.
    int[] lisLength = new int[input.length];
    // index of element that comes before the element at i in the LIS that ends with element at index i.
    int[] prevIndex = new int[input.length];
    // index of element whose 
    int maxLisIndex = 0;
    for (int i=0;i<input.length;i++) {
      lisLength[i] = 1;
      prevIndex[i] = i;
    }
    for (int i=1; i<input.length;i++) {
      System.out.println("Processing Lis for element at index : " + i + ", element value : " + input[i]);
      for (int j=0;j<i;j++) {
        if (input[j].compareTo(input[i]) < 0 && lisLength[i] < lisLength[j] + 1) {
          lisLength[i] = lisLength[j] + 1;
          prevIndex[i] = j;
        }
      }
      System.out.println("lisLength array is " + Arrays.toString(lisLength));
      System.out.println("prevIndex array is " + Arrays.toString(prevIndex));
      if (lisLength[i] > lisLength[maxLisIndex]) {
        maxLisIndex = i;
      }
      System.out.println("maxLisIndex is " + maxLisIndex + "\n");
    }
    lis = (T[]) new Comparable[lisLength[maxLisIndex]];
    int i = maxLisIndex;
    for (int j=lisLength[maxLisIndex] - 1; prevIndex[i] != i && j >= 0; i=prevIndex[i], j--) {
      lis[j] = input[i];
    }
    lis[0] = input[i];
  }

  public T[] getLis() {
    return lis;
  }

  public static void main(String[] args) {
    Integer[] input = {10, 22, 9, 33, 21, 50, 41, 60};
    LongestIncreasingSubsequence<Integer> lis = new LongestIncreasingSubsequence<>(input);
    System.out.println(Arrays.toString(lis.getLis()));
  }

}
