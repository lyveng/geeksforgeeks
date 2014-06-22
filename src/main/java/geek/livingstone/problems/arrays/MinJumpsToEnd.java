package geek.livingstone.problems.arrays;

/**
 * Full problem at
 * http://www.geeksforgeeks.org/minimum-number-of-jumps-to-reach-end-of-a-given-array/
 * 
 * @author emmanuel
 * 
 */
public class MinJumpsToEnd {
  public static int minJumps(int[] A) {
    int[] minJumps = new int[A.length];
    int minVal;
    minJumps[A.length - 1] = 0;
    for (int i = A.length - 2; i >= 0; i--) {
      if (A[i] == 0)
        minJumps[i] = Integer.MAX_VALUE;
      else if (A[i] >= (A.length - i))
        minJumps[i] = 1;
      else {
        minVal = minJumps[i + 1];
        for (int j = 2; j <= A[i] && (i + j) < A.length; j++)
          if (minJumps[i + j] < minVal)
            minVal = minJumps[i + j];
        minJumps[i] = minVal + 1;
      }
    }
    return minJumps[0];
  }

  public static void main(String[] args) {
    System.out.println(minJumps(new int[] {1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9}));
  }

}
