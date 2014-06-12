package geek.livingstone.problems.linkedlist;

import geek.livingstone.adt.LinkedList;
import geek.livingstone.adt.LinkedListNode;

/**
 * Full problem at http://www.geeksforgeeks.org/swap-kth-node-from-beginning-with-kth-node-from-end-in-a-linked-list/
 * 
 * @author emmanuel
 *
 */
public class SwapKFrontWithKEnd {
  public static <T extends Comparable<T>> void swap(LinkedList<T> list, int k) {
    int length = list.getLength();
    if (k > length) return;
    LinkedListNode<T> fromStart = null, fromEnd = null, fromStartPrev = null, fromEndPrev = null, fromStartNext, fromEndNext;
    int kFromStart = k, kFromEnd = length - k + 1;
    if (kFromStart == kFromEnd)
      return;
    if (kFromStart > kFromEnd)
    {
      int tmp = kFromStart;
      kFromStart = kFromEnd;
      kFromEnd = tmp;
    }
    fromStart = list.getHead();
    for (int i=1;i<kFromStart;i++) {
      fromStartPrev = fromStart;
      fromStart = fromStart.getNext();
    }
    fromEnd = list.getHead();
    for (int i=1;i<kFromEnd;i++) {
      fromEndPrev = fromEnd;
      fromEnd = fromEnd.getNext();
    }
    fromStartNext = fromStart.getNext();
    fromEndNext = fromEnd.getNext();
    fromStart.setNext(null);
    fromEnd.setNext(null);

    if (fromStartPrev == null)
      list.setHead(fromEnd);
    else
      fromStartPrev.setNext(fromEnd);
    fromEnd.setNext(fromStartNext);

    fromEndPrev.setNext(fromStart);
    fromStart.setNext(fromEndNext);
  }

  public static void main(String[] args) {
    LinkedList<Integer> a = new LinkedList<>();
    a.push(5);
    a.push(4);
    a.push(3);
    a.push(2);
    a.push(1);
    System.out.println(a);
    swap(a, 4);
    System.out.println(a);
  }

}
