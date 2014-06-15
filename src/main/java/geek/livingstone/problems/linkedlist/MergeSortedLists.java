package geek.livingstone.problems.linkedlist;

import geek.livingstone.adt.LinkedList;
import geek.livingstone.adt.LinkedListNode;

/**
 * Full problem at http://www.geeksforgeeks.org/merge-two-sorted-linked-lists/
 * 
 * @author emmanuel
 * 
 */
public class MergeSortedLists {

  public static <T extends Comparable<T>> LinkedList<T> mergeSorted(LinkedList<T> a, LinkedList<T> b) {
    LinkedListNode<T> head = mergeUtil(a.getHead(), b.getHead());
    LinkedList<T> list = new LinkedList<>();
    list.setHead(head);
    return list;
  }

  public static <T extends Comparable<T>> LinkedListNode<T> mergeUtil(LinkedListNode<T> a, LinkedListNode<T> b) {
    if (a == null && b == null)
      return null;
    else if (a == null)
      return b;
    else if (b == null)
      return a;
    else if (a.getData().compareTo(b.getData()) < 0) {
      a.setNext(mergeUtil(a.getNext(), b));
      return a;
    } else {
      b.setNext(mergeUtil(a, b.getNext()));
      return b;
    }
  }

  public static void main(String[] args) {
    LinkedList<Integer> a = new LinkedList<>();
    LinkedList<Integer> b = new LinkedList<>();
    a.push(5);
    b.push(4);
    a.push(3);
    b.push(2);
    a.push(1);
    System.out.println("a = " + a);
    System.out.println("b = " + b);
    System.out.println();
    System.out.println("Merged = " + mergeSorted(a, b));
  }

}
