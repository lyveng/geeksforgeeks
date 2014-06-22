package geek.livingstone.problems.arrays;

import java.util.Arrays;

/**
 * Full problem at http://www.geeksforgeeks.org/find-subarray-with-given-sum/
 * 
 * @author emmanuel
 * 
 */
public class SubArrayWithGivenSum {
  public static void find(int[] A, int target) {
    int sum = A[0], start = 0, end = 0;
    while (start < A.length && end < A.length) {
      if (sum == target) {
        System.out.println(Arrays.toString(Arrays.copyOfRange(A, start, end + 1)));
        return;
      } else if (sum < target) {
        end++;
        sum += A[end];
      } else {
        sum -= A[start];
        start++;
      }
    }
  }

  public static void main(String[] args) {
    find(new int[] {1, 4, 20, 3, 10, 5}, 33);
    find(new int[] {1, 4, 0, 0, 3, 10, 5}, 7);
    find(new int[] {1, 4}, 0);
  }

}
