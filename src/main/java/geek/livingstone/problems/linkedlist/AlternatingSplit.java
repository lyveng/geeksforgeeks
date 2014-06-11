package geek.livingstone.problems.linkedlist;

import geek.livingstone.adt.LinkedList;
import geek.livingstone.adt.LinkedListNode;

/**
 * Full problem at http://www.geeksforgeeks.org/alternating-split-of-a-given-singly-linked-list/
 * 
 * @author emmanuel
 * 
 */
public class AlternatingSplit {
  public static <T extends Comparable<T>> LinkedList<T> altSplit(LinkedList<T> list) {
    LinkedList<T> b = new LinkedList<>();
    b.setHead(splitUtil(list.getHead()));
    return b;
  }

  private static <T extends Comparable<T>> LinkedListNode<T> splitUtil(LinkedListNode<T> node) {
    if (node == null || node.getNext() == null) return null;
    LinkedListNode<T> a = node;
    LinkedListNode<T> b = a.getNext();
    a.setNext(b.getNext());
    b.setNext(splitUtil(a.getNext()));
    return b;
  }

  public static void main(String[] args) {
    LinkedList<Integer> a = new LinkedList<>();
    a.push(1);
    a.push(0);
    a.push(1);
    a.push(0);
    a.push(1);
    a.push(0);
    System.out.println("Original " + a);
    System.out.println();
    LinkedList<Integer> b = altSplit(a);
    System.out.println("Split 1 : " + a);
    System.out.println("Split 2 : " + b);
  }

}
