package geek.livingstone.problems.arrays;

/**
 * Find element in a rotated sorted array in O(log(n)) Full problem at
 * http://www.geeksforgeeks.org/search-an-element-in-a-sorted-and-pivoted-array/
 * 
 * @author emmanuel
 * 
 */
public class PivotedBinarySearch {
  public static int pivotedBinarySearch(int[] A, int value) {
    int pivot = findPivot(A, 0, A.length - 1);
    if (pivot == -1)
      return binarySearch(A, 0, A.length - 1, value);
    else if (value > A[0])
      return binarySearch(A, 0, pivot, value);
    else
      return binarySearch(A, pivot + 1, A.length - 1, value);
  }

  public static int binarySearch(int[] A, int start, int end, int value) {
    if (start > end || (start == end && A[start] != value)) return -1;
    int mid = (start + end) / 2;
    if (A[mid] == value)
      return mid;
    else if (A[mid] < value)
      return binarySearch(A, mid + 1, end, value);
    else
      return binarySearch(A, start, mid - 1, value);
  }

  private static int findPivot(int[] A, int start, int end) {
    if (start >= end) return -1;
    int mid = (start + end) / 2;
    if (mid > start && A[mid - 1] > A[mid]) return mid - 1;
    if (mid < end && A[mid] > A[mid + 1]) return mid;
    if (A[mid] > A[start])
      return findPivot(A, mid + 1, end);
    else
      return findPivot(A, start, mid - 1);
  }

  public static void main(String[] args) {
    System.out.println(pivotedBinarySearch(new int[] {3,4,5,1,2}, 1));
  }

}
