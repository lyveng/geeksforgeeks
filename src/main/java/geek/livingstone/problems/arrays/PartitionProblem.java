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
    if (totalSum % 2 != 0) {
      System.out.println("No such subset exists.");
      return;
    }
    int targetSum = totalSum / 2;
    // isSubSetAvailable[n][sum] is true iff a subset of A[0...n] exists with sum=sum
    boolean[][] isSubSetAvailable = new boolean[arr.length + 1][targetSum + 1];
    isSubSetAvailable[0][0] = true;
    for (int i = 0; i < isSubSetAvailable.length; i++) {
      isSubSetAvailable[i][0] = true;
    }
    for (int i = 1; i < isSubSetAvailable.length; i++) {
      for (int j = 1; j < isSubSetAvailable[i].length; j++) {
        if (j - arr[i-1] >= 0)
          isSubSetAvailable[i][j] = isSubSetAvailable[i][j] || isSubSetAvailable[i][j - arr[i-1]];
        if (i - 1 >= 0)
          isSubSetAvailable[i][j] = isSubSetAvailable[i][j] || isSubSetAvailable[i - 1][j];
      }
    }
    if (isSubSetAvailable[arr.length][targetSum])
      System.out.println("Subset available");
    else
      System.out.println("No such subset exists.");
  }

  public static void main(String[] args) {
    findPartition(new int[] {1, 5, 11, 5});
    findPartition(new int[] {1, 5, 3});
  }

}
