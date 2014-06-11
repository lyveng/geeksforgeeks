package geek.livingstone.problems.linkedlist;

import geek.livingstone.adt.LinkedList;
import geek.livingstone.adt.LinkedListNode;

/**
 * Full problem at http://www.geeksforgeeks.org/merge-sort-for-linked-list/
 * 
 * @author emmanuel
 * 
 */
public class MergeSort {
  public static <T extends Comparable<T>> void sort(LinkedList<T> list) {
    LinkedListNode<T> head = sortUtil(list.getHead());
    list.setHead(head);
  }

  private static <T extends Comparable<T>> LinkedListNode<T> sortUtil(LinkedListNode<T> node) {
    if (node == null || node.getNext() == null) return node;
    LinkedListNode<T> slow = node;
    LinkedListNode<T> fast = node.getNext();
    while (fast != null && fast.getNext() != null) {
      slow = slow.getNext();
      fast = fast.getNext().getNext();
    }
    LinkedListNode<T> a = node, b = slow.getNext();
    slow.setNext(null);
    a = sortUtil(a);
    b = sortUtil(b);
    return merge(a, b);
  }

  private static <T extends Comparable<T>> LinkedListNode<T> merge(LinkedListNode<T> a, LinkedListNode<T> b) {
    if (a == null && b == null)
      return null;
    else if (a == null)
      return b;
    else if (b == null)
      return a;
    else if (a.getData().compareTo(b.getData()) < 0) {
      a.setNext(merge(a.getNext(), b));
      return a;
    } else {
      b.setNext(merge(a, b.getNext()));
      return b;
    }
  }

  public static void main(String[] args) {
    LinkedList<Integer> a = new LinkedList<>();
    a.push(5);
    a.push(3);
    a.push(1);
    a.push(4);
    a.push(2);
    System.out.println("Original " + a);
    sort(a);
    System.out.println("Sorted " + a);
  }

}
