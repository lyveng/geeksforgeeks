package geek.livingstone.problems.arrays;

import java.util.Arrays;
import java.util.BitSet;

/**
 * Full problem at http://www.geeksforgeeks.org/find-a-sorted-subsequence-of-size-3-in-linear-time/
 * 
 * @author emmanuel
 * 
 */
public class SortedSubSeqOfSize3InLinearTime {
  public static void find(int[] A) {
    BitSet isMinOnLeft = new BitSet(A.length);
    isMinOnLeft.set(0);
    int minIndex = 0, maxIndex = A.length - 1, midIndex = -1;
    // Set isMinOnLeft[i] if A[i] is the min of A[0...i]
    for (int i = 1; i < A.length; i++) {
      if (A[i] < A[minIndex]) {
        isMinOnLeft.set(i);
        minIndex = i;
      }
    }
    if (isMinOnLeft.cardinality() == A.length) {
      System.out.println("No such subseq exists.");
      return;
    }
    // Find the first index from right such that A[i] is not max and A[i:] and not min of A[0:i+1]
    for (int i = A.length - 2; i >= 0; i--) {
      if (A[i] > A[maxIndex]) {
        maxIndex = i;
      } else if (!isMinOnLeft.get(i)) {
        midIndex = i;
        break;
      }
    }
    // Now midIndex has atleast one element less than it on the left and one greater than it on the
    // right.
    // Find those two and return
    int[] subSeq = new int[] {0, A[midIndex], 0}, subSeqIndex = new int[] {-1, midIndex, -1};
    for (int i = midIndex - 1; i >= 0; i++)
      if (A[i] < subSeq[1]) {
        subSeq[0] = A[i];
        subSeqIndex[0] = i;
        break;
      }
    for (int i = midIndex + 1; i < A.length; i++)
      if (A[i] > subSeq[1]) {
        subSeq[2] = A[i];
        subSeqIndex[2] = i;
        break;
      }
    System.out.println(Arrays.toString(subSeqIndex));
    System.out.println(Arrays.toString(subSeq));
  }

  public static void main(String[] args) {
    find(new int[] {12, 11, 10, 5, 6, 2, 30});
    find(new int[] {1, 2, 3, 4});
    find(new int[] {4, 3, 2, 1});
  }

}
