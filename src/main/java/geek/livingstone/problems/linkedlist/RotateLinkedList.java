package geek.livingstone.problems.linkedlist;

import geek.livingstone.adt.LinkedList;
import geek.livingstone.adt.LinkedListNode;

/**
 * Full problem at http://www.geeksforgeeks.org/rotate-a-linked-list/
 * 
 * @author emmanuel
 * 
 */
public class RotateLinkedList {
  public static <T extends Comparable<T>> void rotate(LinkedList<T> list, int k) {
    LinkedListNode<T> head = list.getHead(), newLast = list.getHead(), newHead, last = list.getHead();
    while (last != null && last.getNext() != null)
      last = last.getNext();
    for (int i = 1; i < k; i++)
      newLast = newLast.getNext();
    newHead = newLast.getNext();
    newLast.setNext(null);
    last.setNext(head);
    list.setHead(newHead);
  }

  public static void main(String[] args) {
    LinkedList<Integer> a = new LinkedList<>();
    a.push(5);
    a.push(4);
    a.push(3);
    a.push(2);
    a.push(1);
    System.out.println(a);
    rotate(a, 3);
    System.out.println(a);
  }

}
