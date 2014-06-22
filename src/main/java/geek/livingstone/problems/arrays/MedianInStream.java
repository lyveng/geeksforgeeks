package geek.livingstone.problems.arrays;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Full problem at http://www.geeksforgeeks.org/median-of-stream-of-integers-running-integers/
 * 
 * @author emmanuel
 * 
 */
public class MedianInStream {
  public static void printMedian(int[] A) {
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(A.length, new Comparator<Integer>() {
      @Override
      public int compare(Integer o1, Integer o2) {
        return o2.compareTo(o1);
      }
    });
    int median = 0, sizeDiff;
    for (int i = 0; i < A.length; i++) {
      if (A[i] < median)
        maxHeap.add(A[i]);
      else
        minHeap.add(A[i]);
      sizeDiff = Math.abs(minHeap.size() - maxHeap.size());
      if (sizeDiff > 1) {
        if (minHeap.size() > maxHeap.size())
          maxHeap.add(minHeap.remove());
        else
          minHeap.add(maxHeap.remove());
        median = (minHeap.peek() + maxHeap.peek()) / 2;
      } else if (sizeDiff == 1) {
        if (minHeap.size() > maxHeap.size())
          median = minHeap.peek();
        else
          median = maxHeap.peek();
      } else
        median = (minHeap.peek() + maxHeap.peek()) / 2;
      System.out.println("Median of " + Arrays.toString(Arrays.copyOf(A, i + 1)) + " is " + median);
    }
  }

  public static void main(String[] args) {
    int[] A = {5, 15, 1, 3, 2, 8, 7, 9, 10, 6, 11, 4};
    printMedian(A);
  }
}
