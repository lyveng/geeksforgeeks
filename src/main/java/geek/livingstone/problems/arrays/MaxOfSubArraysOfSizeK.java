package geek.livingstone.problems.arrays;

import java.util.LinkedList;

/**
 * Full problem at http://www.geeksforgeeks.org/maximum-of-all-subarrays-of-size-k/
 * 
 * @author emmanuel
 *
 */
public class MaxOfSubArraysOfSizeK {
  public static void findMax(int[] A, int k) {
    assert k <= A.length;
    LinkedList<Integer> q = new LinkedList<>();
    int i;
    for (i=0;i<k;i++)
    {
      while (!q.isEmpty() && A[q.getLast()] < A[i])
        q.removeLast();
      q.addLast(i);
    }
    int max = A[q.getFirst()];
    for (;i<A.length;i++)
    {
      while (!q.isEmpty() && q.getFirst() <= i-k)
        q.removeFirst();
      while (!q.isEmpty() && A[q.getLast()] < A[i])
        q.removeLast();
      q.addLast(i);
      if (A[q.getFirst()] > max)
        max = A[q.getFirst()];
      System.out.print(max + " ");
    }
    System.out.println();
  }

  public static void main(String[] args) {
    findMax(new int[] {1, 2, 3, 1, 4, 5, 2, 3, 6}, 3);
    findMax(new int[] {8, 5, 10, 7, 9, 4, 15, 12, 90, 13}, 4);
  }

}
