package geek.livingstone.problems.arrays;


/**
 * Median of two sorted arrays Full problem at
 * http://www.geeksforgeeks.org/median-of-two-sorted-arrays/
 * 
 * @author emmanuel
 * 
 */
public class MedianOfTwoSortedArrays {
  public static int median(int[] A, int[] B) {
    assert A.length == B.length;
    return medianUtil(A, B, 0, A.length-1, 0, B.length-1);
  }

  private static int medianUtil(int[] A, int[] B, int AStart, int AEnd, int BStart, int BEnd) {
    if (AEnd - AStart + 1 == 2) {
      return (Math.max(A[AStart], B[BStart]) + Math.max(A[AStart + 1], B[BStart + 1])) / 2;
    }
    int AMid = (AStart + AEnd) / 2, BMid = (BStart + BEnd) / 2;
    if (A[AMid] == B[BMid])
      return A[AMid];
    else if (A[AMid] < B[BMid])
      return medianUtil(A, B, AMid+1, AEnd, BStart, BMid-1);
    else
      return medianUtil(A, B, AStart, AMid-1, BMid+1, BEnd);
  }

  public static void main(String[] args) {
    int ar1[] = {1, 12, 15, 26, 38};
    int ar2[] = {2, 13, 17, 30, 45};
    System.out.println(median(ar1, ar2));
  }

}
