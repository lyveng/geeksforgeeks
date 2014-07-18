package geek.livingstone.problems.arrays;

/**
 * Full problem at http://www.geeksforgeeks.org/dynamic-programming-set-18-partition-problem/
 * 
 * @author emmanuel
 * 
 */
public class PartitionProblem {
  public static void findPartition(int[] arr) {
    int totalSum = 0;
    for (int i = 0; i < arr.length; i++) {
      totalSum += arr[i];
    }
    if ((totalSum & 1) == 1) {
      System.out.println("Subset not available");
      return;
    }
    int targetSum = totalSum >> 1;
    boolean[][] sumExists = new boolean[targetSum + 1][arr.length];
    for (int i = 0; i < arr.length; i++) {
      sumExists[0][i] = true;
    }
    for (int sum = 1; sum <= targetSum; sum++) {
      for (int i = 0; i < arr.length; i++) {
        if (arr[i] <= sum && i - 1 >= 0)
          sumExists[sum][i] = sumExists[sum][i - 1] || sumExists[sum - arr[i]][i - 1];
      }
    }
    System.out.println(sumExists[targetSum][arr.length - 1]);
  }

  public static void main(String[] args) {
    findPartition(new int[] {1, 5, 11, 5});
    findPartition(new int[] {1, 5, 3});
    findPartition(new int[] {3, 1, 1, 2, 2, 1});
    findPartition(new int[] {9, 1, 1, 2, 2, 1});
  }

}
